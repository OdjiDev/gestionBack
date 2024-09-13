package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.Bureau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BureauRepository extends JpaRepository<Bureau, Integer> {
    // all crud database methods
}
