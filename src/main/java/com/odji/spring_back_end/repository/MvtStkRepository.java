package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.MvtStk;
import com.odji.spring_back_end.model.Personel;
import com.odji.spring_back_end.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface MvtStkRepository extends JpaRepository<MvtStk, Integer> {

        }
