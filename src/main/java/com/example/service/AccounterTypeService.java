package com.example.service;

import com.example.model.AccounterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Serhiy on 15.05.2016.
 */
@Repository
public interface AccounterTypeService extends JpaRepository<AccounterType,Long>{
    AccounterType getByKind(String kind);
}
