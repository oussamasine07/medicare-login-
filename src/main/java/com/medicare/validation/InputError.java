package com.medicare.validation;

public class InputError {
    public String errorField;
    public String errorMessage;

    public InputError ( String errorField, String errorMessage) {
        this.errorField = errorField;
        this.errorMessage = errorMessage;
    }

    public String getErrorField() {
        return errorField;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
