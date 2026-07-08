package com.utkarsa.task_management_api.service;

import com.utkarsa.task_management_api.dto.request.RegisterRequest;
import com.utkarsa.task_management_api.dto.response.UserResponse;

public interface UserService {

    UserResponse register(RegisterRequest request);

}