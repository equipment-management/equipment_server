package com.dgsw.equipment.global.infra.raspberry.service;

import com.dgsw.equipment.global.config.WebClientConfiguration;
import com.dgsw.equipment.global.infra.raspberry.ro.HashRo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class RaspberryService {

    private final WebClientConfiguration webClient;

    private Mono<String> getHash() {
        return webClient.raspberryClient()
                .get()
                .uri("/")
                .retrieve()
                .bodyToMono(String.class);
    }

    public HashRo returnHash() {
//        String hash = getHash().block();
        Random random = new Random();

        String hashCode = random.ints(48,123)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return new HashRo(hashCode, "test");

//        try {
//            JSONObject jsonObject = new JSONObject(hash);
//
//            return new HashRo(jsonObject.get("id").toString(),
//                    jsonObject.get("text").toString());
//        } catch (JSONException e) {
//            throw new RuntimeException(e);
//        }
    }

}
