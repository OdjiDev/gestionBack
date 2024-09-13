package com.odji.spring_back_end.repository;
import com.odji.spring_back_end.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository  extends JpaRepository<Categorie, Integer> {
    // all crud database methods
}
