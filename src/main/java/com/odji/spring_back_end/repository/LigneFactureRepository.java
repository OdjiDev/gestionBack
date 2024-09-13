package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.LigneFacture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneFactureRepository  extends JpaRepository<LigneFacture, Integer> {
    // all crud database methods
}
