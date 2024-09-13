package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.CategorieDto;
import com.odji.spring_back_end.model.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategorieService {


    public List<CategorieDto> categoriesDtoList(List<Categorie> categories){
        return categories.stream()
                .map(this::categorieToDto) //utilise la methode de conversion individuel
                .collect(Collectors.toList());

            }


    public CategorieDto categorieToDto(Categorie categorie) {
        if (categorie == null) {
            return null;
        }

        CategorieDto categorieDto = new CategorieDto();
        categorieDto.setId(categorie.getId());
        categorieDto.setNomcategorie(categorie.getNomcategorie());
        categorieDto.setCode(categorie.getCode());
        categorieDto.setDesignation(categorie.getDesignation());


        return categorieDto;
    }
        public Categorie dtoToCategorie(CategorieDto categorieDto) {
            if (categorieDto == null) {
                return null;
            }

            Categorie categorie = new Categorie();
            categorie.setId(categorieDto.getId());
            categorie.setNomcategorie(categorieDto.getNomcategorie());
            categorie.setCode(categorieDto.getCode());
            categorie.setDesignation(categorieDto.getDesignation());

            return categorie;
        }
    }

