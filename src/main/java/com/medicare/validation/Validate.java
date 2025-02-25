package com.medicare.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static InputError validateEmpty ( String field, String value ) {
        if ( value.isEmpty() ) return new InputError(field, field + " field is required");
        return null;
    }

    public static InputError validateEmail ( String field, String value ) {
        String pattern = "^([a-zA-Z0-9_.-]+)@([a-z]+)\\.([a-z]+)$";
        Pattern ptr = Pattern.compile(pattern);
        Matcher match = ptr.matcher(value);

        if ( !match.find() ) return new InputError(field, "invalid Email");

        return null;
    }

    public static InputError validatePhone ( String field, String value ) {
        String pattern = "^((06)|(05)|(07))([0-9]{8})$";
        Pattern ptr = Pattern.compile(pattern);
        Matcher match = ptr.matcher(value);

        if ( !match.find() ) return new InputError(field, "invalid Phone");

        return null;
    }

}
