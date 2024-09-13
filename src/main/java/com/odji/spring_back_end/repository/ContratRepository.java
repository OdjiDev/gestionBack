package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository  extends JpaRepository<Contrat, Integer> {
    // all crud database methods
}

