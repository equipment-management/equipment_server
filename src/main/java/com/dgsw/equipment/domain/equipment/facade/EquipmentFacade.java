package com.dgsw.equipment.domain.equipment.facade;

import com.dgsw.equipment.domain.admin.exception.AlreadyExistsHashCodeException;
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
@Transactional(readOnly = true)
public class EquipmentFacade {

    private final EquipmentRepository equipmentRepository;
    private final UserEquipmentRepository userEquipmentRepository;

    public void existsByEquipmentName(String equipmentName) {
        equipmentRepository.findByEquipmentName(equipmentName)
                .ifPresent(m -> {
                    throw EquipmentExistsByEquipmentNameException.EXCEPTION;
                });
    }

    public Equipment findEquipmentById(Long id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> EquipmentNotFoundException.EXCEPTION);
    }

    public List<Equipment> findEquipmentAllByEquipmentName(String equipmentName) {
        return equipmentRepository.findAllByEquipmentName(equipmentName);
    }

    public List<Equipment> findEquipmentAllByType(EquipmentType type) {
        return equipmentRepository.findAllByType(type);
    }

    public List<Equipment> findEquipmentAllByUser(User user) {
        List<UserEquipment> userEquipment = userEquipmentRepository.findAllByUser(user);
        return userEquipment.stream()
                .map(UserEquipment::getEquipment)
                .collect(Collectors.toList());
    }

    public List<UserEquipment> findUserEquipmentAllByUser(User user) {
        return userEquipmentRepository.findAllByUser(user);
    }

    public List<UserEquipment> findUserEquipmentAllByStatus(EquipmentStatus status) {
        return userEquipmentRepository.findAllByStatus(status);
    }

    public UserEquipment checkEquipmentPermission(User user, Equipment equipment) {
        return userEquipmentRepository.findByUserAndEquipment(user, equipment)
                .orElseThrow(() -> UserEquipmentForbiddenException.EXCEPTION);
    }

    public UserEquipment findUserEquipmentByUserEquipmentId(Long userEquipmentId) {
        return userEquipmentRepository.findById(userEquipmentId)
                .orElseThrow(() -> UserEquipmentNotFoundException.EXCEPTION);
    }

    public void existsCheckHashCode(String hash) {
        if (userEquipmentRepository.existsByHashCode(hash))
            throw AlreadyExistsHashCodeException.EXCEPTION;
    }

}
