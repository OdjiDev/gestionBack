package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.Avarie;
import com.odji.spring_back_end.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  AvarieRepository extends JpaRepository<Avarie, Integer> {
//    List<Avarie> findAllByAvarieId(Integer idAvarie);


}
