package com.medicare.model;

public class Doctor extends User {

    private String specialty;
    private String phone;
    private String address;

    public Doctor (int id, String fullName, String email ) {
        super(id, fullName, email);
    }

    public Doctor (int id, String fullName, String email, String specialty, String phone, String address ) {
        super(id, fullName, email);
        this.specialty = specialty;
        this.phone = phone;
        this.address = address;
    }

    public String getPhone () { return  this.phone; }
    public void setPhone ( String phone ) { this.phone = phone; }

    public String getSpecialty () { return this.specialty; }
    public void setSpecialty () { this.specialty = specialty; }

    public String getAddress () { return this.address; }
    public void setAddress ( String address ) { this.address = address; }


}
