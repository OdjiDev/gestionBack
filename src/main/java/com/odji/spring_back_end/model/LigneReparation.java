package com.odji.spring_back_end.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Entity
@Builder
@Table(name = "lignereparation")
@AllArgsConstructor
@NoArgsConstructor
public class LigneReparation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "idproduit")
    private  Produit produit;

    @ManyToOne
    @JoinColumn(name = "idreparer")
    private  Reparer reparer;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "date")
    private Date date;
}
