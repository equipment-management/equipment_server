package com.dgsw.equipment.domain.user.domain.repository;

import com.dgsw.equipment.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUniqueId(String uniqueId);

    Optional<User> findByUniqueId(String uniqueId);

}
