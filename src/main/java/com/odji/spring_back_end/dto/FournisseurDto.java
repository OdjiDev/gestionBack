package com.odji.spring_back_end.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odji.spring_back_end.model.Facture;
import com.odji.spring_back_end.model.Fournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FournisseurDto {

    private Integer id;

    private String nom;

    private String prenom ;


    private String adresse;

    private String mail;

    private String numtel;

    @JsonIgnore
    private List<FactureDto> factures;

}
