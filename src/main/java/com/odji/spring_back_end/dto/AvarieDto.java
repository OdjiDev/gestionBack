package com.odji.spring_back_end.dto;

import com.odji.spring_back_end.model.Avarie;
import lombok.*;


import java.math.BigDecimal;
import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AvarieDto {

    private Integer id;

    private BigDecimal quantite;

    private String date;

    private String motif;

    private ProduitDto produitDto;
}








