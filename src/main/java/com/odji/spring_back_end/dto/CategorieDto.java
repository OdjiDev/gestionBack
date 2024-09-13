package com.odji.spring_back_end.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odji.spring_back_end.model.Categorie;
import lombok.*;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategorieDto {

    private Integer id;

    private String nomcategorie;


    private String code;

    private String designation;

    @JsonIgnore
    private List<ProduitDto> produits;



    }



