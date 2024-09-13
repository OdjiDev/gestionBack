package com.odji.spring_back_end.dto;

import com.odji.spring_back_end.model.LigneFactureReparer;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LigneFactureReparerDto {

    private Integer id;

//
   private  ProduitDto produitDto;

    private  ReparerDto reparerDto;

    private FactureReparerDto facturereparerDto ;


    private BigDecimal quantite;

    private Date date;


}
