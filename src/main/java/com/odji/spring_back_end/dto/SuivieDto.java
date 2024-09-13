package com.odji.spring_back_end.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odji.spring_back_end.model.Bureau;
import com.odji.spring_back_end.model.Personel;
import com.odji.spring_back_end.model.Produit;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class SuivieDto {


    private Integer id;

    private String numero;

    private String code;

    private String date;

    private String designation;

    private String nomComplet;

    private String typeSuivie;

    private String etat;

    private ProduitDto produitDto;

    private PersonelDto personelDto;

   // private BureauDto bureauDto;

}
