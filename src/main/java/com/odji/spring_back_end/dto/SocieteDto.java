package com.odji.spring_back_end.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odji.spring_back_end.model.Societe;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SocieteDto {

    private Integer id;

    private String nom;

    private String adresse;

    private String numerofiscal;

    @JsonIgnore
    private List<ContratDto> contrats;

    @JsonIgnore
    private List<FactureReparerDto> facturereparers;


}
