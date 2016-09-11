package com.example.service;

import com.example.model.BuildingType;
import com.example.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Serhiy on 15.05.2016.
 */
@Repository
public interface StreetService extends JpaRepository<Street,Long> {
    BuildingType getByStreetName(String streetName);
  }
