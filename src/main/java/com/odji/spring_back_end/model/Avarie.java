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
@Builder
@Entity
@Table(name = "avarie")
@AllArgsConstructor
@NoArgsConstructor
public class Avarie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "date")
    private String date;

    @Column(name = "motif")
    private String motif;

    @ManyToOne
    @JoinColumn(name = "idproduit")
    private Produit produit ;
}
