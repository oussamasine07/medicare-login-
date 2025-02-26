package com.medicare.dto;

import jakarta.validation.constraints.*;

public class RegisterDTO {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalide Email")
    private String email;

    @NotBlank(message = "password is required")
    //@Min(4)
    private String password;

    @NotBlank(message = "please select a role")
    private String role;

//    @NotBlank(message = "please confirm you password")
//    private String confirmPassword;

    public RegisterDTO (String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
//        this.confirmPassword = confirmPassword;
    }

    public RegisterDTO (String fullName, String email, String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }
    public String getEmail () {
        return email;
    }

    public void setPassword (String password) { this.password = password; }
    public String getPassword () { return this.password; }

    public String getRole () { return this.role; }
}
