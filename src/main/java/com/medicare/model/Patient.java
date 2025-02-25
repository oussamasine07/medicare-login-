package com.medicare.model;

public class Patient extends User {

    private String phone;
    private String address;

    public Patient (int id, String fullName, String email) {
        super(id, fullName, email);
    }

    public Patient (int id, String fullName, String email, String phone, String address ) {
        super(id, fullName, email);
        this.phone = phone;
        this.address = address;
    }

    public String getAddress () { return this.address; }
    public void setAddress ( String address ) { this.address = address; }

    public String getPhone () { return  this.phone; }
    public void setPhone ( String phone ) { this.phone = phone; }
}
