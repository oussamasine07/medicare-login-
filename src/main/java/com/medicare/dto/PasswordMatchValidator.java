package com.medicare.dto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

//public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, RegisterDTO> {
//    @Override
//    public boolean isValid(RegisterDTO dto, ConstraintValidatorContext context) {
//        if (dto.getPassword() == null || dto.getConfirmPassword() == null) {
//            return false; // Return false if any field is null
//        }
//        return dto.getPassword().equals(dto.getConfirmPassword());
//    }
//}
