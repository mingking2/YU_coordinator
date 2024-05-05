package project.yucoordinator.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SignupDTO {

    @Size(min = 3, max = 25)
    @NotEmpty(message = "사용자ID는 필수")
    private String username;

    @NotEmpty(message = "비밀번호는 필수")
    private String password;

    @NotEmpty(message = "이메일도 필수")
    @Email
    private String email;
}
