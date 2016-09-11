package com.example.model;

import javax.persistence.*;

/**
 * Created by Serhiy on 11.05.2016.
 */
@Entity
@Table(name = "building")
public class Building {
    @Id
    @GeneratedValue
    @Column(name = "id_building")
    private Long idBuilding;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_street")
    //@Column(name = "id_street")
    private Street street;
    @Column(name = "building_number")
    private Long buildNumber;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_build_type")
    private BuildingType buildingType;

    public Building() {
    }

    public Building(Street street, Long buildNumber, BuildingType buildingType) {
        this.street = street;
        this.buildNumber = buildNumber;
        this.buildingType = buildingType;
    }

    public Long getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(Long idBuilding) {
        this.idBuilding = idBuilding;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Long getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(Long buildNumber) {
        this.buildNumber = buildNumber;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }
}