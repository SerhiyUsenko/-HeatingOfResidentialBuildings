package com.example.service;

import com.example.model.AccounterType;
import com.example.model.BuildingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Serhiy on 15.05.2016.
 */
@Repository
public interface BuildingTypeService extends JpaRepository<BuildingType,Long> {
    BuildingType getByKind(String kind);

}
