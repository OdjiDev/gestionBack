package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.LigneDemande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneDemandeRepository extends JpaRepository <LigneDemande, Integer>{
    // all crud database methods
}
