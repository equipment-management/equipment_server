package com.dgsw.equipment.domain.equipment.service;

import com.dgsw.equipment.domain.equipment.domain.Equipment;
import com.dgsw.equipment.domain.equipment.domain.UserEquipment;
import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentStatus;
import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentType;
import com.dgsw.equipment.domain.equipment.domain.repository.EquipmentRepository;
import com.dgsw.equipment.domain.equipment.domain.repository.UserEquipmentRepository;
import com.dgsw.equipment.domain.equipment.exception.UserEquipmentReturnPermissionException;
import com.dgsw.equipment.domain.equipment.facade.EquipmentFacade;
import com.dgsw.equipment.domain.equipment.presentation.dto.request.CreateEquipment;
import com.dgsw.equipment.domain.equipment.presentation.dto.request.EquipmentRequest;
import com.dgsw.equipment.domain.equipment.presentation.dto.response.EquipmentListResponse;
import com.dgsw.equipment.domain.equipment.presentation.dto.response.EquipmentResponse;
import com.dgsw.equipment.domain.equipment.presentation.dto.response.UserEquipmentListResponse;
import com.dgsw.equipment.domain.equipment.presentation.dto.response.UserEquipmentResponse;
import com.dgsw.equipment.domain.user.domain.User;
import com.dgsw.equipment.domain.user.facade.UserFacade;
import com.dgsw.equipment.global.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentFacade equipmentFacade;
    private final UserFacade userFacade;
    private final EquipmentRepository equipmentRepository;
    private final UserEquipmentRepository userEquipmentRepository;

    public void createEquipment(CreateEquipment request) {
        equipmentFacade.existsByEquipmentName(request.getName());
        Equipment equipment = request.toEntity();
        equipmentRepository.save(equipment);
    }

    public void requestEquipment(Long id, EquipmentRequest request) {
        Equipment equipment = equipmentFacade.findEquipmentById(id);

        User user = userFacade.getCurrentUser();

        UserEquipment userEquipment = UserEquipment.builder()
                .equipment(equipment)
                .user(user)
                .rentaledAt(request.getRentaledAt())
                .terminateRental(request.getTerminateRental())
                .build();

        userEquipmentRepository.save(userEquipment);
    }

    @Transactional
    public void returnEquipment(Long id) {
        User user = userFacade.getCurrentUser();
        Equipment equipment = equipmentFacade.findEquipmentById(id);

        UserEquipment userEquipment = equipmentFacade.checkEquipmentPermission(user, equipment);
        if(!userEquipment.getStatus().equals(EquipmentStatus.APPROVE))
            throw UserEquipmentReturnPermissionException.EXCEPTION;

        userEquipment.returnEquipment();
        equipmentRepository.save(equipment);
    }

    public UserEquipmentListResponse getEquipmentAllByUser() {
        User user = userFacade.getCurrentUser();

        List<UserEquipmentResponse> list = equipmentFacade.findUserEquipmentAllByUser(user)
                .stream().map(ResponseUtil::getUserEquipmentResponseByUserEquipment)
                .collect(Collectors.toList());

        return UserEquipmentListResponse.builder()
                .list(list)
                .build();
    }

    public EquipmentListResponse getEquipmentAllByType(EquipmentType type) {
        List<Equipment> equipments = equipmentFacade.findEquipmentAllByType(type);
        List<EquipmentResponse> list = equipments.stream()
                .map(ResponseUtil::getEquipmentResponse)
                .collect(Collectors.toList());

        return EquipmentListResponse.builder()
                .list(list)
                .build();
    }


}
