package com.odji.spring_back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@Entity
@Table(name = "fournisseur")
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom ;

    //private addresse du client

    @Column(name ="adresse" )
    private String adresse;

    @Column(name = "mail")
    private String mail;

    @Column(name = "numtel")
    private String numtel;

    @OneToMany(mappedBy = "fournisseur")
    private List<Facture> facture;


}
