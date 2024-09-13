package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository  extends JpaRepository<Fournisseur, Integer> {
    // all crud database methods
}

