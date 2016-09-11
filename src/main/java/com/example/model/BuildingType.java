package com.example.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Serhiy on 14.05.2016.
 */
@Entity
@Table(name = "buildingtype")
public class BuildingType {
        @Id
        @GeneratedValue
        @Column(name = "id_build_type")
        private Long id;
        @Column(name = "kind")
        private String kind;
        @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "buildingType")
        private List<Building> buildingList;

    public BuildingType() {
    }

    public BuildingType(String kind, List<Building> buildingList) {
        this.kind = kind;
        this.buildingList = buildingList;
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

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }
}
