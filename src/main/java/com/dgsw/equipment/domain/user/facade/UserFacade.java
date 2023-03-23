package com.dgsw.equipment.domain.user.facade;

import com.dgsw.equipment.domain.user.domain.User;
import com.dgsw.equipment.domain.user.domain.repository.UserRepository;
import com.dgsw.equipment.global.security.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        AuthDetails auth = (AuthDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return auth.getUser();
    }

}
