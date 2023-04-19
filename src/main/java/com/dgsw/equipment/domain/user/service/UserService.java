package com.dgsw.equipment.domain.user.service;

import com.dgsw.equipment.domain.user.domain.User;
import com.dgsw.equipment.domain.user.facade.UserFacade;
import com.dgsw.equipment.domain.user.presentation.dto.response.UserResponse;
import com.dgsw.equipment.global.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFacade userFacade;

    public UserResponse getUserInfo() {
        User user = userFacade.getCurrentUser();
        return ResponseUtil.getUserResponse(user);
    }

}
