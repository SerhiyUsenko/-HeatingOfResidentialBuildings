package com.example.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Serhiy on 14.05.2016.
 */
@Entity
@Table(name = "accountertype")
public class AccounterType {
    @Id
    @GeneratedValue
    @Column(name = "id_acc_type")
    private Long id;
    @Column(name = "kind")
    private String kind;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "accounterType")
    private List<Accounter> accounterList;

    public AccounterType() {
    }

    public AccounterType(Long id, String kind, List<Accounter> accounterList) {
        this.id = id;
        this.kind = kind;
        this.accounterList = accounterList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<Accounter> getAccounterList() {
        return accounterList;
    }

    public void setAccounterList(List<Accounter> accounterList) {
        this.accounterList = accounterList;
    }
}
