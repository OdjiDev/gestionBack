package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.Societe;
import com.odji.spring_back_end.model.Suivie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuivieRepository  extends JpaRepository<Suivie, Integer> {
    // all crud database methods
}