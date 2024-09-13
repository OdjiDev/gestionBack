package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository  extends JpaRepository<Demande, Integer> {
    // all crud database methods
}
