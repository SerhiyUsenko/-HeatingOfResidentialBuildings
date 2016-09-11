package com.example.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Serhiy on 14.05.2016.
 */
@Entity
@Table(name = "street")
public class Street {
    @Id
    @GeneratedValue
    @Column(name = "id_street")
    private Long id;
    @Column(name = "street_name")
    private String streetName;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "street")
    private List<Building> buildingList;

    public Street() {
    }

    public Street(String streetName, List<Building> buildingList) {
        this.streetName = streetName;
        this.buildingList = buildingList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }
}
