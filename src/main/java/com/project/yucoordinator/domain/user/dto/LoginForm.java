package com.project.yucoordinator.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {

    // TODO VAlidation

    private String username;
    private String password;
}
