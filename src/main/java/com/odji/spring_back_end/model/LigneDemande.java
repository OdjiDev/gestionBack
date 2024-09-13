package com.odji.spring_back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "lignedemande")
@AllArgsConstructor
@NoArgsConstructor
public class LigneDemande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "idproduit")
    private  Produit produit;

    @OneToMany(mappedBy = "lignedemande")
    private List<Demande> demande;
}
