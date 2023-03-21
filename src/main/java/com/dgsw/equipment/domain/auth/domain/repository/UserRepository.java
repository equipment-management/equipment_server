package com.dgsw.equipment.domain.auth.domain.repository;

import com.dgsw.equipment.domain.auth.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUniqueId(String uniqueId);

    Optional<User> findByUniqueId(String uniqueId);

}
