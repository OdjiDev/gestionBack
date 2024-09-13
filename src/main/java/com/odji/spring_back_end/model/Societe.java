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
@Table(name = "societe")
@AllArgsConstructor
@NoArgsConstructor
public class Societe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "numerofiscal")
    private String numerofiscal;

    @OneToMany(mappedBy = "societe")
    private List<Contrat> contrat;

    @OneToMany(mappedBy = "societe")
    private List<FactureReparer> factureReparer;
}
