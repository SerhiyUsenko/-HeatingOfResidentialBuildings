package com.example.service;

import com.example.model.Accounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Serhiy on 10.05.2016.
 */
@Repository
@Transactional
public interface AccounterService extends JpaRepository<Accounter,Long> {
    public void deleteByIdAccounter(Long idAccounter);
}
