package com.dgsw.equipment.global.utils;

import com.dgsw.equipment.domain.equipment.domain.Equipment;
import com.dgsw.equipment.domain.equipment.domain.UserEquipment;
import com.dgsw.equipment.domain.equipment.presentation.dto.response.EquipmentResponse;
import com.dgsw.equipment.domain.equipment.presentation.dto.response.UserEquipmentResponse;
import com.dgsw.equipment.domain.user.domain.User;
import com.dgsw.equipment.domain.user.presentation.dto.response.UserResponse;

import java.time.format.DateTimeFormatter;

public class ResponseUtil {

    public static UserResponse getUserResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .profileImage(user.getProfileImage())
                .role(user.getRole())
                .build();
    }

    public static EquipmentResponse getEquipmentResponse(Equipment equipment) {
        return EquipmentResponse.builder()
                .equipmentId(equipment.getEquipmentId())
                .equipmentName(equipment.getEquipmentName())
                .brand(equipment.getBrand()).type(equipment.getType())
                .size(equipment.getSize() - equipment.getRentalSize())
                .build();
    }

    public static UserEquipmentResponse getUserEquipmentResponse(UserEquipment equipment) {
        return UserEquipmentResponse.builder()
                .userEquipmentId(equipment.getEquipment().getEquipmentId())
                .equipmentName(equipment.getEquipment().getEquipmentName())
                .brand(equipment.getEquipment().getBrand()).type(equipment.getEquipment().getType())
                .size(equipment.getEquipment().getSize() - equipment.getEquipment().getRentalSize())
                .status(equipment.getStatus())
                .rentaledAt(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(equipment.getRentaledAt()))
                .terminateRental(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(equipment.getTerminateRental()))
                .reason(equipment.getReason()).name(equipment.getUser().getName())
                .grade(equipment.getUser().getGrade()).room(equipment.getUser().getRoom()).number(equipment.getUser().getNumber())
                .build();
    }
}
