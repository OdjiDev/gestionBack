package com.odji.spring_back_end.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Entity
@Builder
@Table(name = "contrat")
@AllArgsConstructor
@NoArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "nom")
    private String nom;


    @Column(name = "datedebut")
    private String datedebut;

    @Column(name = "datedefin")
    private String datedefin;

    @ManyToOne
    @JoinColumn(name = "idsociete")
    private Societe societe ;
}
