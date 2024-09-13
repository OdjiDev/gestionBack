package com.odji.spring_back_end.dto;

import com.odji.spring_back_end.model.Personel;
import com.odji.spring_back_end.model.Produit;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignalerDto {
    private Integer id;

    private String etat;

    private Produit produit;

    private Personel personel;

}
