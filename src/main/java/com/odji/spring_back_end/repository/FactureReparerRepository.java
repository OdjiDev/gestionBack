package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.FactureReparer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureReparerRepository  extends JpaRepository<FactureReparer, Integer> {
    // all crud database methods
}
