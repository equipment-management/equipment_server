package com.dgsw.equipment.global.infra.raspberry.ro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
@AllArgsConstructor
public class HashRo {

    private String hash;
    private String text;

}
