package com.dgsw.equipment.global.infra.oauth.dodam.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DOpenResponse implements Serializable {

    private DOpenInfoResponse data;

}
