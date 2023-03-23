package com.dgsw.equipment.global.security.auth;

import com.dgsw.equipment.domain.user.domain.repository.UserRepository;
import com.dgsw.equipment.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String uniqueId) throws UsernameNotFoundException {
        return userRepository.findByUniqueId(uniqueId)
                .map(AuthDetails::new)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
