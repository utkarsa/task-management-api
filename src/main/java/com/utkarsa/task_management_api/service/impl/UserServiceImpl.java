package com.utkarsa.task_management_api.service.impl;

import com.utkarsa.task_management_api.dto.request.RegisterRequest;
import com.utkarsa.task_management_api.dto.response.UserResponse;
import com.utkarsa.task_management_api.entity.User;
import com.utkarsa.task_management_api.enums.Role;
import com.utkarsa.task_management_api.repository.UserRepository;
import com.utkarsa.task_management_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);

        User savedUser = userRepository.save(user);

        return UserResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .build();
    }
}