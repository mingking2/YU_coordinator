package com.project.yucoordinator.domain.user.service;

import com.project.yucoordinator.domain.user.dto.SignupForm;
import com.project.yucoordinator.domain.user.entity.UserEntity;
import com.project.yucoordinator.domain.user.entity.RoleType;
import com.project.yucoordinator.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserEntity save(SignupForm request) {
        UserEntity userEntity = UserEntity.builder()
                .username(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .roleType(RoleType.USER)
                .build();
        userRepository.save(userEntity);
        return userEntity;
    }
}
