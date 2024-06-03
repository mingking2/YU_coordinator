package com.example.demo.domain.user.dto;

import com.example.demo.domain.user.entity.RoleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupForm {
    private String name;
    private String email;
    private String password;
    private RoleType roleType;

}
