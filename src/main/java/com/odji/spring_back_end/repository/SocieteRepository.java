package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocieteRepository  extends JpaRepository<Societe, Integer> {
    // all crud database methods
}
