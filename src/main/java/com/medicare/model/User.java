package com.medicare.model;

public abstract class User {

    private int id;
    private String fullName;
    private String email;
    private Role role;
    private String password;

    public User (int id, String fullName, String email, String password, Role role ) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public User (int id, String fullName, String email, Role role ) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
    }

    public int getId () { return this.id; }
    public String getFullName () { return this.fullName; }
    public String getEmail () { return this.email; }
    public String getPassword () { return this.password; }
    public Role getRole () { return this.role; }

}
