package com.dgsw.equipment.domain.admin.service;

import com.dgsw.equipment.domain.equipment.domain.UserEquipment;
import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentStatus;
import com.dgsw.equipment.domain.equipment.domain.repository.EquipmentRepository;
import com.dgsw.equipment.domain.equipment.domain.repository.UserEquipmentRepository;
import com.dgsw.equipment.domain.equipment.facade.EquipmentFacade;
import com.dgsw.equipment.domain.equipment.presentation.dto.response.UserEquipmentListResponse;
import com.dgsw.equipment.domain.equipment.presentation.dto.response.UserEquipmentResponse;
import com.dgsw.equipment.domain.user.facade.UserFacade;
import com.dgsw.equipment.global.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final EquipmentRepository equipmentRepository;
    private final UserEquipmentRepository userEquipmentRepository;
    private final EquipmentFacade equipmentFacade;
    private final UserFacade userFacade;

    public UserEquipmentListResponse getUserEquipmentAllByApprove() {
        userFacade.checkPermission();

        List<UserEquipment> userEquipments = equipmentFacade
                .findUserEquipmentAllByStatus(EquipmentStatus.PENDING);

        List<UserEquipmentResponse> list = userEquipments.stream()
                .map(ResponseUtil::getUserEquipmentResponse)
                .collect(Collectors.toList());

        return UserEquipmentListResponse.builder()
                .list(list)
                .build();
    }

    public void denyUserEquipment(Long userEquipmentId) {
        userFacade.checkPermission();

        UserEquipment equipment = equipmentFacade.findUserEquipmentByUserEquipmentId(userEquipmentId);
        equipment.denyEquipment();

        userEquipmentRepository.save(equipment);
    }

    public void approveEquipment(Long userEquipmentId, String hashCode) {
        userFacade.checkPermission();

        UserEquipment equipment = equipmentFacade.findUserEquipmentByUserEquipmentId(userEquipmentId);
        equipment.addHashCode(hashCode);
        equipment.approveEquipment();

        equipment.getEquipment().addRental();
        equipmentRepository.save(equipment.getEquipment());
    }

    public void returnEquipment(Long userEquipmentId, String hashCode) {
        userFacade.checkPermission();

        UserEquipment equipment = equipmentFacade.findUserEquipmentByUserEquipmentId(userEquipmentId);
        equipment.checkHashCode(hashCode);
        equipment.returnEquipment();

        equipment.getEquipment().returnRental();
        equipmentRepository.save(equipment.getEquipment());
    }

}
