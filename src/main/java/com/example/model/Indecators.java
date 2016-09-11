package com.example.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.sql.Timestamp;

/**
 * Created by Serhiy on 15.05.2016.
 */
@Entity
@Table(name = "indecator")
public class Indecators {
    @Id
    @GeneratedValue
    @Column(name = "id_indecator")
    private Long idIndecator;
    @Column(name = "indecator")
    private Long indecator;
    @Column(name = "date_measurment")
    private Timestamp date;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    public Indecators(Long idIndecator, Long indecator, Timestamp date, Customer customer) {
        this.idIndecator = idIndecator;
        this.indecator = indecator;
        this.date = date;
        this.customer = customer;
    }

    public Indecators() {
    }

    public Long getIdIndecator() {
        return idIndecator;
    }

    public void setIdIndecator(Long idIndecator) {
        this.idIndecator = idIndecator;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getIndecator() {
        return indecator;
    }

    public void setIndecator(Long indecator) {
        this.indecator = indecator;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
