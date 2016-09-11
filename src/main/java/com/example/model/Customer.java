package com.example.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Serhiy on 11.05.2016.
 */
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "id_customer")
    private Long idCustomer;
    @Column(name = "f_name")
    private String fName;
    @Column(name = "s_name")
    private String sName;
    @Column(name = "birth_day")
    private Date birthDay;
    @Column(name = "id_accounter")
    private Long idAccounter;
    @Column(name = "id_building")
    private Long idBuilding;
    @Column(name = "adres")
    private String Adres;
    @OneToOne(fetch = FetchType.EAGER,mappedBy = "customer")
    private Indecators indecator;


    public Customer(String fName, String sName, Date birthDay, Long idAccounter, Long idBuilding, String adres, Indecators indecator) {
        this.fName = fName;
        this.sName = sName;
        this.birthDay = birthDay;
        this.idAccounter = idAccounter;
        this.idBuilding = idBuilding;
        Adres = adres;
        this.indecator = indecator;
    }

    public Customer() {
    }

    public Indecators getIndecator() {
        return indecator;
    }

    public void setIndecator(Indecators indecator) {
        this.indecator = indecator;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String adres) {
        Adres = adres;
    }

    public Long getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(Long idBuilding) {
        this.idBuilding = idBuilding;
    }

    public Long getIdAccounter() {
        return idAccounter;
    }

    public void setIdAccounter(Long idAccounter) {
        this.idAccounter = idAccounter;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
