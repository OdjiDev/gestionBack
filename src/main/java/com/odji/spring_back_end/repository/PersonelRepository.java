package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.Personel;
import com.odji.spring_back_end.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonelRepository  extends JpaRepository<Personel, Integer> {
    // all crud database methods
 //  List<Personel> findAllByPersonelId(Integer idPersonel);
}
