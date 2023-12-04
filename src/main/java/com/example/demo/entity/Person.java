package com.example.demo.entity;

import com.example.demo.repository.AppointmentRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "persons")
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(nullable = false)
    private int privLevel;
    @Column(nullable = false)
    private String cnp;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String address;


    @OneToMany(mappedBy = "person")
    private List<Appointment> appointments;


    @OneToMany(mappedBy = "patient")
    private List<Report> reports;

    @JsonManagedReference(value="appoint")
    public List<Appointment> getAppointments() {
        return appointments;
    }

    @JsonManagedReference(value="repo")
     public List<Report> getReports() {
        return reports;
    }


    public Person() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public Person(int privLevel, String cnp, Date birthDate, String firstName, String lastName, String userName, String password, String address) {
        this.privLevel = privLevel;
        this.cnp = cnp;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.address = address;
    }
    */
    public Person(int privLevel, String cnp, Date birthDate, String firstName, String lastName, String userName, String password, String address, List<Appointment> appointments, List<Report> reports) {
        this.privLevel = privLevel;
        this.cnp = cnp;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.appointments = appointments;
        this.reports = reports;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getPrivLevel() {
        return privLevel;
    }

    public void setPrivLevel(int privLevel) {
        this.privLevel = privLevel;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setAppointments(List<Appointment> appointments) {
        appointments = appointments;
    }



    public void setReports(List<Report> reports) {
        reports = reports;
    }
}
