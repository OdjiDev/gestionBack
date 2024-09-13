package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.LigneReparation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneReparationRepository  extends JpaRepository<LigneReparation, Integer> {
    // all crud database methods
}
