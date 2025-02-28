package com.medicare.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginDTO {

    @NotBlank(message = "email is required")
    @Email(message = "invalid email")
    private String email;

    @NotBlank(message = "password is required")
    private String password;

    public LoginDTO ( String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail () { return this.email; }
    public String getPassword () { return this.password; }

}
