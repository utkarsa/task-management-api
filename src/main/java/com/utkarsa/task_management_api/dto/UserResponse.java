package com.utkarsa.task_management_api.dto;


import com.utkarsa.task_management_api.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private Long id;

    private String name;

    private String email;

    private Role role;

}
