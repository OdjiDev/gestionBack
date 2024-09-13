package com.odji.spring_back_end.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odji.spring_back_end.model.MvtStk;
import com.odji.spring_back_end.model.Suivie;
import lombok.*;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BureauDto {

    private Integer id;

    private String nom;

    @JsonIgnore
    private List<DemandeDto> demandes;

    private DepartementDto departementDto;

    @JsonIgnore
    private List<MvtStk> MvtStks;

    @JsonIgnore
    private List<MvtStk> MvtStk;

    @JsonIgnore
    private List<Suivie> suivie;
}
