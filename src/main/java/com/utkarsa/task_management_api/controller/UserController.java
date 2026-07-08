package com.utkarsa.task_management_api.controller;

import com.utkarsa.task_management_api.dto.request.RegisterRequest;
import com.utkarsa.task_management_api.dto.response.UserResponse;
import com.utkarsa.task_management_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }
}