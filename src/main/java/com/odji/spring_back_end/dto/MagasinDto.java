package com.odji.spring_back_end.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odji.spring_back_end.model.Magasin;
import com.odji.spring_back_end.model.Produit;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class MagasinDto {

    private Integer id;

    private String nom;

    @JsonIgnore
    private List<ProduitDto> produits;

    }



