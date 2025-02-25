package com.medicare.model;

public abstract class User {

    private int id;
    private String fullName;
    private String email;

    public User (int id, String fullName, String email ) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }


}
