package com.odji.spring_back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data@Builder
@Entity
@Table(name = "personel")
@AllArgsConstructor
@NoArgsConstructor
public class Personel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = " dateDeNaissance")
    private String dateDeNaissance;

    @Column(name = "lieuDeNaissance")
    private String lieuDeNaissance;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "numero")
    private String numero;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "idrole")
    private Option role;

    @OneToMany(mappedBy = "personel")
    private List<MvtStk> MvtStk;


    @OneToMany(mappedBy = "personel")
    private List<Suivie> suivie;


    @OneToMany(mappedBy = "personel")
    private List<Demande> demande;


}

