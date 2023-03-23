package com.dgsw.equipment.domain.equipment.domain.repository;

import com.dgsw.equipment.domain.equipment.domain.Equipment;
import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    List<Equipment> findAllByEquipmentName(String equipmentName);
    List<Equipment> findAllByType(EquipmentType type);

    Optional<Equipment> findByEquipmentName(String equipmentName);

}
