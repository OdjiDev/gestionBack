package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.Categorie;
import com.odji.spring_back_end.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
    // all crud database methods
}
