package com.dgsw.equipment.domain.admin.service;

import com.dgsw.equipment.domain.admin.exception.EquipmentNotReturnRequestException;
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

    public UserEquipmentListResponse getUserEquipmentAllByPending() {
        List<UserEquipment> userEquipments = equipmentFacade
                .findUserEquipmentAllByStatus(EquipmentStatus.PENDING);

        List<UserEquipmentResponse> list = userEquipments.stream()
                .map(ResponseUtil::getUserEquipmentResponse)
                .collect(Collectors.toList());

        return UserEquipmentListResponse.builder()
                .list(list)
                .build();
    }

    public UserEquipmentListResponse getUserEquipmentAllByApprove() {
        List<UserEquipment> userEquipments = equipmentFacade
                .findUserEquipmentAllByStatus(EquipmentStatus.APPROVE);

        List<UserEquipmentResponse> list = userEquipments.stream()
                .map(ResponseUtil::getUserEquipmentResponse)
                .collect(Collectors.toList());

        return UserEquipmentListResponse.builder()
                .list(list)
                .build();
    }

    public UserEquipmentListResponse getUserEquipmentAllByReturnRequest() {
        List<UserEquipment> userEquipments = equipmentFacade
                .findUserEquipmentAllByStatus(EquipmentStatus.RETURN_REQUEST);

        List<UserEquipmentResponse> list = userEquipments.stream()
                .map(ResponseUtil::getUserEquipmentResponse)
                .collect(Collectors.toList());

        return UserEquipmentListResponse.builder()
                .list(list)
                .build();
    }

    public void denyUserEquipment(Long userEquipmentId) {
        UserEquipment equipment = equipmentFacade.findUserEquipmentByUserEquipmentId(userEquipmentId);
        equipment.denyEquipment();

        userEquipmentRepository.save(equipment);
    }

    public void approveEquipment(Long userEquipmentId, String hashCode) {
        UserEquipment equipment = equipmentFacade.findUserEquipmentByUserEquipmentId(userEquipmentId);
        equipment.addHashCode(hashCode);
        equipment.approveEquipment();

        equipment.getEquipment().addRental();
        equipmentRepository.save(equipment.getEquipment());
    }

    public void returnEquipment(Long userEquipmentId, String hashCode) {
        UserEquipment equipment = equipmentFacade.findUserEquipmentByUserEquipmentId(userEquipmentId);

        if (equipment.getStatus().equals(EquipmentStatus.RETURN_REQUEST))
            throw EquipmentNotReturnRequestException.EXCEPTION;

        equipment.checkHashCode(hashCode);
        equipment.returnEquipment();

        equipment.getEquipment().returnRental();
        equipmentRepository.save(equipment.getEquipment());
    }

}
