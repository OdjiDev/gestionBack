package com.odji.spring_back_end.dto;


import lombok.*;

import java.math.BigDecimal;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MvtStkDto {

    private Integer id;

    private BigDecimal prixAchat;

    private BigDecimal quantite;

    private String date;

    private PersonelDto personelDto;

    private ProduitDto produitDto;

}
