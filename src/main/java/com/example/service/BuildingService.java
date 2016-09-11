package com.example.service;

import com.example.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Serhiy on 14.05.2016.
 */
@Repository
public interface BuildingService extends JpaRepository<Building,Long>{
}
