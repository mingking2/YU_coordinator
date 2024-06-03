package com.project.yucoordinator.domain.user.dto;

import com.project.yucoordinator.domain.user.entity.RoleType;
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
