package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.CategorieDto;
import com.odji.spring_back_end.dto.DemandeDto;
import com.odji.spring_back_end.dto.DepartementDto;
import com.odji.spring_back_end.model.Categorie;
import com.odji.spring_back_end.model.Demande;
import com.odji.spring_back_end.model.Departement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartementService {


    public List<DepartementDto> departementDtoList(List<Departement> departements){
        return departements.stream()
                .map(this::departementToDto) //utilise la methode de conversion individuel
                .collect(Collectors.toList());

    }
    public DepartementDto departementToDto(Departement departement) {
        if (departement == null) {
            return null;
        }

        DepartementDto departementDto = new DepartementDto();
        departementDto.setId(departement.getId());
        departementDto.setCode(departement.getCode());
        departementDto.setCreatedAt(departement.getCreatedAt());
        departementDto.setNom(departement.getNom());
        return departementDto;
    }


    public Departement dtoToDepartement (DepartementDto departementDto) {
        if (departementDto== null) {
            return null;
        }

        Departement departement= new Departement();
        departement.setId(departementDto.getId());
        departement.setCode(departementDto.getCode());
        departement.setCreatedAt(departementDto.getCreatedAt());
        departement.setNom(departementDto.getNom());
        return departement;
    }


}
