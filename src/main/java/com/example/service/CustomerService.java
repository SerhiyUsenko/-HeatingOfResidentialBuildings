package com.example.service;

import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Serhiy on 11.05.2016.
 */
@Repository
public interface CustomerService extends JpaRepository<Customer,Long>{
}
