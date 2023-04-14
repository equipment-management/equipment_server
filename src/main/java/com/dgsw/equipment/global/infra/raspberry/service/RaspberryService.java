package com.dgsw.equipment.global.infra.raspberry.service;

import com.dgsw.equipment.global.config.WebClientConfiguration;
import com.dgsw.equipment.global.infra.raspberry.ro.HashRo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class RaspberryService {

    private final WebClientConfiguration webClient;

    private Mono<String> getHash() {
        return webClient.raspberryClient()
                .get()
                .uri("/json_test")
                .retrieve()
                .bodyToMono(String.class);
    }

    public HashRo returnHash() {
        String hash = getHash().block();

        try {
            JSONObject jsonObject = new JSONObject(hash);

            return new HashRo(jsonObject.get("id").toString(),
                    jsonObject.get("text").toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
