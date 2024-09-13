package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository  extends JpaRepository<Facture, Integer> {
    // all crud database methods
}
