package com.example.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Serhiy on 10.05.2016.
 */
@Entity
@Table(name = "accounter")
public class Accounter {
    @Id
    @GeneratedValue
    @Column(name = "id_accounter")
    private Long idAccounter;
    @Column(name = "accounter_name")
    private String nameAccounter;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_acc_type")
    private AccounterType accounterType;
    @Column(name = "acc_producer")
    private String accProducer;
    @Column(name = "instal_date")
    private Date instalDate;

    public Accounter() {
    }

    public String getNameAccounter() {
        return nameAccounter;
    }

    public void setNameAccounter(String nameAccounter) {
        this.nameAccounter = nameAccounter;
    }

    public Long getIdAccounter() {
        return idAccounter;
    }

    public void setIdAccounter(Long idAccounter) {
        this.idAccounter = idAccounter;
    }


    public AccounterType getAccounterType() {
        return accounterType;
    }

    public void setAccounterType(AccounterType accounterType) {
        this.accounterType = accounterType;
    }

    public String getAccProducer() {
        return accProducer;
    }

    public void setAccProducer(String accProducer) {
        this.accProducer = accProducer;
    }

    public Date getInstalDate() {
        return instalDate;
    }

    public void setInstalDate(Date instalDate) {
        this.instalDate = instalDate;
    }

    public Accounter(String nameAccounter, AccounterType accounterType, String accProducer, Date instalDate) {
        this.nameAccounter = nameAccounter;
        this.accounterType = accounterType;
        this.accProducer = accProducer;
        this.instalDate = instalDate;
    }
}
