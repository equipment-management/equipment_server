package com.dgsw.equipment.domain.equipment.domain.repository;

import com.dgsw.equipment.domain.equipment.domain.Equipment;
import com.dgsw.equipment.domain.equipment.domain.UserEquipment;
import com.dgsw.equipment.domain.equipment.domain.enums.EquipmentStatus;
import com.dgsw.equipment.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserEquipmentRepository extends JpaRepository<UserEquipment, Long> {

    Optional<UserEquipment> findByEquipment(Equipment equipment);

    Optional<UserEquipment> findByUserAndEquipment(User user, Equipment equipment);

    List<UserEquipment> findAllByUser(User user);

    List<UserEquipment> findAllByStatus(EquipmentStatus status);

    boolean existsByHashCode(String hash);

}
