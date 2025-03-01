package com.medicare.model;

public class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private User user;
    private String appDate;
    private String appTime;
    private String motif;
    private boolean isCanceled;
    private boolean isDone;

    public Appointment () {}

    public Appointment ( int id, Patient patient, Doctor doctor, String appDate, String appTime, String motif, boolean isCanceled, boolean isDone) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.appDate = appDate;
        this.appTime = appTime;
        this.motif = motif;
        this.isCanceled = isCanceled;
        this.isDone = isDone;
    }

//    public Appointment ( int id, User user, String appDate, String appTime, String motif, boolean isCanceled, boolean isDone) {
//        this.id = id;
//        this.appDate = appDate;
//        this.appTime = appTime;
//        this.motif = motif;
//        this.isCanceled = isCanceled;
//        this.isDone = isDone;
//    }

//    public Appointment ( Patient patient, Doctor doctor, String appDate, String appTime, String motif, boolean isCanceled, boolean isDone) {
//        this.patient = patient;
//        this.doctor = doctor;
//        this.appDate = appDate;
//        this.appTime = appTime;
//        this.motif = motif;
//        this.isCanceled = isCanceled;
//        this.isDone = isDone;
//    }

    public int getId () { return this.id; }

    public Patient getPatient () { return this.patient; }
    public void setPatient ( Patient patient ) { this.patient = patient; }

    public Doctor getDoctor ( Doctor doctor ) { return this.doctor; }
    public void setDoctor ( Doctor doctor ) { this.doctor = doctor; }

    public String getAppDate () { return this.appDate; }
    public void setAppDate ( String appDate ) { this.appTime = appDate; }

    public String getAppTime () { return this.appTime; }
    public void setAppTime ( String appTime ) { this.appTime = appTime; }

    public String getMotif () { return this.motif; }
    public void setMotif ( String motif ) { this.motif = motif; }

    public boolean getIsCanceled () { return this.isCanceled; }

    public boolean getIsDone () { return this.isDone; }

}




















