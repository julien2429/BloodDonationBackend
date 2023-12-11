package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name= "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReport;
    @Column(nullable = true)
    private int idAppointment;
    @Column(nullable = false)
    private int ALT;
    @Column(nullable = false)
    private boolean syphilisTotalAB;
    @Column(nullable = false)
    private boolean antiHCV;
    @Column(nullable = false)
    private boolean antiHiv1over2;
    @Column(nullable = false)
    private boolean antiHtlv1over2;
    @Column(nullable = false)
    private String RH;
    @Column(nullable = false)
    private String bloodType;

    @OneToOne(mappedBy = "report")
    private Appointment appointment;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUser")
    private Person patient;

    @JsonBackReference(value="repo")
    public Person getPatient(){
        return patient;
    }

    @JsonManagedReference(value="reportAppoint")
    public Appointment getAppointment() {return appointment; }


    public Report() {

    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public Report(int idAppointment, int ALT, boolean syphilisTotalAB, boolean antiHCV, boolean antiHiv1over2, boolean antiHtlv1over2, @Nonnull String RH, @Nonnull String bloodType) {
        this.idAppointment = idAppointment;
        this.ALT = ALT;
        this.syphilisTotalAB = syphilisTotalAB;
        this.antiHCV = antiHCV;
        this.antiHiv1over2 = antiHiv1over2;
        this.antiHtlv1over2 = antiHtlv1over2;
        this.RH = RH;
        this.bloodType = bloodType;
    }

    public int getIdReport() {
        return idReport;
    }

    public void setIdReport(int idReport) {
        this.idReport = idReport;
    }



    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public int getALT() {
        return ALT;
    }

    public void setALT(int ALT) {
        this.ALT = ALT;
    }

    public boolean isSyphilisTotalAB() {
        return syphilisTotalAB;
    }

    public void setSyphilisTotalAB(boolean syphilisTotalAB) {
        this.syphilisTotalAB = syphilisTotalAB;
    }

    public boolean isAntiHCV() {
        return antiHCV;
    }

    public void setAntiHCV(boolean antiHCV) {
        this.antiHCV = antiHCV;
    }

    public boolean isAntiHiv1over2() {
        return antiHiv1over2;
    }

    public void setAntiHiv1over2(boolean antiHiv1over2) {
        this.antiHiv1over2 = antiHiv1over2;
    }

    public boolean isAntiHtlv1over2() {
        return antiHtlv1over2;
    }

    public void setAntiHtlv1over2(boolean antiHtlv1over2) {
        this.antiHtlv1over2 = antiHtlv1over2;
    }

    @Nonnull
    public String getRH() {
        return RH;
    }

    public void setRH(@Nonnull String RH) {
        this.RH = RH;
    }

    @Nonnull
    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(@Nonnull String bloodType) {
        this.bloodType = bloodType;
    }
}
