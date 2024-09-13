package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.Personel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Personel,Long>{
    // all crud database methods
}
