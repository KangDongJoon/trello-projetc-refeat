package com.dj.trelloprojetcrepeat.auth.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    @NotBlank(message = "이메일은 필수사항입니다.")
    @Email(message = "이메일 형식을 맞춰주세요.")
    private String email;

    @Pattern(regexp = "^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$",
            message = "비밀번호는 대소문자 포함 영문 + 숫자 + 특수문자 최소 1글자 포함, 최소 8글자 이상")
    @NotBlank(message = "비밀번호는 필수사항입니다.")
    private String password;

    @NotBlank(message = "이름은 필수사항입니다.")
    private String userName;

    @NotBlank(message = "권한선택은 필수사항입니다.")
    private String userRole;
}
