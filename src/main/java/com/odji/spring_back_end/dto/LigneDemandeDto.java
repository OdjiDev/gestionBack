package com.odji.spring_back_end.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odji.spring_back_end.model.LigneDemande;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LigneDemandeDto {

    private Integer id;


    private BigDecimal quantite;


    private Date date;


    private  ProduitDto produit;

    @JsonIgnore
    private List<DemandeDto> demandes;

}
