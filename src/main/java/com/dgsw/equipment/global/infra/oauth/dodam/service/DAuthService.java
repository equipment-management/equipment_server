package com.dgsw.equipment.global.infra.oauth.dodam.service;

import com.dgsw.equipment.global.config.AppProperties;
import com.dgsw.equipment.global.config.WebClientConfiguration;
import com.dgsw.equipment.global.exception.InternalServerErrorException;
import com.dgsw.equipment.global.infra.oauth.dodam.dto.request.DAuthRequest;
import com.dgsw.equipment.global.infra.oauth.dodam.dto.response.DAuthResponse;
import com.dgsw.equipment.global.infra.oauth.dodam.dto.response.DOpenResponse;
import com.dgsw.equipment.global.infra.oauth.dodam.exception.DAuthFalsifyCodeException;
import com.dgsw.equipment.global.infra.oauth.dodam.exception.DAuthWrongTokenException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DAuthService {

    private final AppProperties appProperties;
    private final WebClientConfiguration webClient;

    private Mono<DAuthResponse> getToken(String code) {
        DAuthRequest request = DAuthRequest.builder()
                .code(code).clientId(appProperties.getClientId())
                .clientSecret(appProperties.getClientSecret())
                .build();

        return webClient.dauthAuthClient()
                .post()
                .uri("/token")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        clientResponse -> Mono.error(DAuthFalsifyCodeException.EXCEPTION))
                .onStatus(HttpStatus::is5xxServerError,
                        clientResponse -> Mono.error(InternalServerErrorException.EXCEPTION))
                .bodyToMono(DAuthResponse.class);
    }

    public Mono<DOpenResponse> getUserInfo(String code) {
        return getToken(code)
                .map(DAuthResponse::getAccessToken)
                .flatMap(token -> {
                    HttpHeaders headers = new HttpHeaders();
                    headers.setBearerAuth(token);
                    return webClient.dauthOpenClient()
                            .get()
                            .uri("/user")
                            .headers(httpHeaders -> httpHeaders.addAll(headers))
                            .retrieve()
                            .onStatus(HttpStatus::is4xxClientError,
                                    clientResponse -> Mono.error(DAuthWrongTokenException.EXCEPTION))
                            .onStatus(HttpStatus::is5xxServerError,
                                    clientResponse -> Mono.error(InternalServerErrorException.EXCEPTION))
                            .bodyToMono(DOpenResponse.class);
                });
    }
}
