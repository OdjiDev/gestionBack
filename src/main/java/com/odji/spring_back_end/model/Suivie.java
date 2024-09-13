package com.odji.spring_back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "suivie")
@AllArgsConstructor
@NoArgsConstructor
public class Suivie {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "numero")
        private String numero;

        @Column(name = "code")
        private String code;

        @Column(name = "date")
        private String date;

        @Column(name = "designation")
        private String designation;

        @Column(name = "typeSuivie")
        private String typeSuivie;

        @Column(name = "nomComplet")
        private String nomComplet;

        @Column(name = "etat")
        private String etat;

        @ManyToOne
        @JoinColumn(name = "idproduit")
        private Produit produit ;

            @ManyToOne
            @JoinColumn(name = "idpersonel")
            private Personel personel;

        @ManyToOne
        @JoinColumn(name = "idbureau")
        private Bureau bureau;

//        @OneToMany(mappedBy = "produit")
//        private List<MvtStk> MvtStk;


    }

