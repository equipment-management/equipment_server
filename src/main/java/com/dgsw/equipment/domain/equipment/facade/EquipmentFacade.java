package com.dgsw.equipment.domain.equipment.facade;

import com.dgsw.equipment.domain.equipment.domain.Equipment;
import com.dgsw.equipment.domain.equipment.domain.UserEquipment;
import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentStatus;
import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentType;
import com.dgsw.equipment.domain.equipment.domain.repository.EquipmentRepository;
import com.dgsw.equipment.domain.equipment.domain.repository.UserEquipmentRepository;
import com.dgsw.equipment.domain.equipment.exception.EquipmentExistsByEquipmentNameException;
import com.dgsw.equipment.domain.equipment.exception.EquipmentNotFoundException;
import com.dgsw.equipment.domain.equipment.exception.UserEquipmentForbiddenException;
import com.dgsw.equipment.domain.equipment.exception.UserEquipmentNotFoundException;
import com.dgsw.equipment.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EquipmentFacade {

    private final EquipmentRepository equipmentRepository;
    private final UserEquipmentRepository userEquipmentRepository;

    @Transactional
    public void existsByEquipmentName(String equipmentName) {
        equipmentRepository.findByEquipmentName(equipmentName)
                .ifPresent(m -> {
                    throw EquipmentExistsByEquipmentNameException.EXCEPTION;
                });
    }

    @Transactional
    public Equipment findEquipmentById(Long id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> EquipmentNotFoundException.EXCEPTION);
    }

    @Transactional
    public List<Equipment> findEquipmentAllByEquipmentName(String equipmentName) {
        return equipmentRepository.findAllByEquipmentName(equipmentName);
    }

    @Transactional
    public List<Equipment> findEquipmentAllByType(EquipmentType type) {
        return equipmentRepository.findAllByType(type);
    }

    @Transactional
    public List<Equipment> findEquipmentAllByUser(User user) {
        List<UserEquipment> userEquipment = userEquipmentRepository.findAllByUser(user);
        return userEquipment.stream()
                .map(UserEquipment::getEquipment)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<UserEquipment> findUserEquipmentAllByUser(User user) {
        return userEquipmentRepository.findAllByUser(user);
    }

    @Transactional
    public List<UserEquipment> findUserEquipmentAllByStatus(EquipmentStatus status) {
        return userEquipmentRepository.findAllByStatus(status);
    }

    @Transactional
    public UserEquipment checkEquipmentPermission(User user, Equipment equipment) {
        return userEquipmentRepository.findByUserAndEquipment(user, equipment)
                .orElseThrow(() -> UserEquipmentForbiddenException.EXCEPTION);
    }

    @Transactional
    public UserEquipment findUserEquipmentByUserEquipmentId(Long userEquipmentId) {
        return userEquipmentRepository.findById(userEquipmentId)
                .orElseThrow(() -> UserEquipmentNotFoundException.EXCEPTION);
    }

}
