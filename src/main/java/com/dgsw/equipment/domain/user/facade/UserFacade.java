package com.dgsw.equipment.domain.user.facade;

import com.dgsw.equipment.domain.user.domain.User;
import com.dgsw.equipment.domain.user.domain.enums.UserRole;
import com.dgsw.equipment.domain.user.domain.repository.UserRepository;
import com.dgsw.equipment.domain.admin.exception.AdminForbiddenException;
import com.dgsw.equipment.global.security.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        AuthDetails auth = (AuthDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return auth.getUser();
    }

    public void checkPermission() {
        User user = getCurrentUser();
        if(!user.getRole().equals(UserRole.ROLE_ADMIN))
            throw AdminForbiddenException.EXCEPTION;
    }

}
