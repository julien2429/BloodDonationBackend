package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAppointment;

    @Column(nullable = false)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm")
    private Date dateOfAppointment;
    @Column(nullable = true)
    private String arm;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idReport")
    private Report report;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")
    private Person person;


    @JsonBackReference(value="appoint")
    public Person getPerson(){
        return person;
    }

    @JsonBackReference(value="reportApoint")
    public Report getReport() {
        return report;
    }
    public Appointment( Date dateOfAppointment, String arm, Report report, Person person) {

        this.dateOfAppointment = dateOfAppointment;
        this.arm = arm;
        this.report = report;
        this.person = person;
    }

    public Appointment() {

    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }





    public Date getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public String getArm() {
        return arm;
    }

    public void setArm(String arm) {
        this.arm = arm;
    }


    public void setReport(Report report) {
        this.report = report;
    }



    public void setPerson(Person person) {
        this.person = person;
    }
}
