package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProduitRepository  extends JpaRepository<Produit, Integer> {

    Optional<Produit> findArticleByCodeproduit(String codeproduit);

    Optional<Produit> findById(int id);
   List<Produit> findAllByCategorieId(Integer idCategorie);



    // Méthode pour trouver tous les produits sauf ceux qui ont une avarie
    @Query("SELECT p FROM Produit p WHERE p.id NOT IN (SELECT a.produit.id FROM Avarie a)")
    List<Produit> findAllWithoutAvarie();



}
