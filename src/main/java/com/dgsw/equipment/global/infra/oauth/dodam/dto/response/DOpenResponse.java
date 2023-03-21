package com.dgsw.equipment.global.infra.oauth.dodam.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DOpenResponse implements Serializable {

    @JsonProperty("data")
    private DOpenInfoResponse data;

}
