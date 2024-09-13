package com.odji.spring_back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "mvtstk")
@AllArgsConstructor
@NoArgsConstructor
public class MvtStk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "prixAchat")
    private BigDecimal prixAchat;

    @Column(name = "quantite")
    private BigDecimal quantite;


    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "idproduit",nullable = false)
    private Produit produit;


    @ManyToOne
    @JoinColumn(name = "idpersonel")
    private Personel personel ;




}
