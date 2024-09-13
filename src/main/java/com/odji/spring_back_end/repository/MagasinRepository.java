package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagasinRepository  extends JpaRepository<Magasin, Integer> {
    // all crud database methods
}
