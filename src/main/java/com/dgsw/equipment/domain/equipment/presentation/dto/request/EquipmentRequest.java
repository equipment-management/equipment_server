package com.dgsw.equipment.domain.equipment.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EquipmentRequest {

    private LocalDate rentaledAt;
    private LocalDate terminateRental;

}
