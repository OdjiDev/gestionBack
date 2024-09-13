package com.odji.spring_back_end.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@Table(name = "bureau")
@AllArgsConstructor
@NoArgsConstructor
public class Bureau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "bureau")
    private List<Demande> demande;

    @ManyToOne
    @JoinColumn(name = "iddepartement")
    private Departement departement;


    @OneToMany(mappedBy = "bureau")
    private List<Suivie> suivies;



}
