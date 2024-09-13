package com.odji.spring_back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data@Builder
@Entity
@Table(name = "magasin")
@AllArgsConstructor
@NoArgsConstructor

public class Magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

//    @OneToMany(mappedBy = "magasin")
//    private List<Produit> produit;

}
