package com.odji.spring_back_end.model;


import com.odji.spring_back_end.dto.ProduitDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "lignefacture")
@AllArgsConstructor
@NoArgsConstructor
public class                                                                                                              LigneFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idproduit")
    private  Produit produit;

    @ManyToOne
    @JoinColumn(name = "idfacture")
    private  Facture facture;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "date")
    private String date;


}
