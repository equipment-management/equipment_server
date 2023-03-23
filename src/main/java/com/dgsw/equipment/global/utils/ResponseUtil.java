package com.dgsw.equipment.global.utils;

import com.dgsw.equipment.domain.equipment.domain.Equipment;
import com.dgsw.equipment.domain.equipment.domain.UserEquipment;
import com.dgsw.equipment.domain.equipment.presentation.dto.response.EquipmentResponse;
import com.dgsw.equipment.domain.equipment.presentation.dto.response.UserEquipmentResponse;
import com.dgsw.equipment.domain.user.domain.User;
import com.dgsw.equipment.domain.user.presentation.dto.response.UserResponse;

public class ResponseUtil {

    public static UserResponse getUserResponse(User user) {
        return UserResponse.builder()
                .uniqueId(user.getUniqueId())
                .grade(user.getGrade()).room(user.getRoom())
                .number(user.getNumber()).name(user.getName())
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

    public static UserEquipmentResponse getUserEquipmentResponseByUserEquipment(UserEquipment equipment) {
        return UserEquipmentResponse.builder()
                .equipmentId(equipment.getEquipment().getEquipmentId())
                .equipmentName(equipment.getEquipment().getEquipmentName())
                .brand(equipment.getEquipment().getBrand()).type(equipment.getEquipment().getType())
                .size(equipment.getEquipment().getSize() - equipment.getEquipment().getRentalSize())
                .status(equipment.getStatus())
                .build();
    }
}
