package com.dgsw.equipment.domain.auth.domain.repository;

import com.dgsw.equipment.domain.auth.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}
