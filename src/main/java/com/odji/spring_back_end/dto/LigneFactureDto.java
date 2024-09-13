package com.odji.spring_back_end.dto;

import com.odji.spring_back_end.model.Facture;
import com.odji.spring_back_end.model.LigneFacture;
import com.odji.spring_back_end.model.Produit;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LigneFactureDto {

    private Integer id;

    private ProduitDto produitDto;

    private FactureDto factureDto;

    private BigDecimal quantite;

    private String date;

}

