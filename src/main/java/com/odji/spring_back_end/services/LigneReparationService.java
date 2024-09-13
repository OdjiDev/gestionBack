package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.AvarieDto;
import com.odji.spring_back_end.dto.LigneDemandeDto;
import com.odji.spring_back_end.dto.LigneReparationDto;
import com.odji.spring_back_end.model.Avarie;
import com.odji.spring_back_end.model.LigneDemande;
import com.odji.spring_back_end.model.LigneReparation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LigneReparationService {
    private  final ProduitService produitService;

    public List<LigneReparationDto> LigneReparations(List<LigneReparation> ligneReparations) {
        return ligneReparations.stream()
                .map(this::ligneReparationToDto)
                .collect(Collectors.toList());
    }
    public LigneReparationDto ligneReparationToDto(LigneReparation ligneReparation) {
        if (ligneReparation == null) {
            return null;
        }
        LigneReparationDto ligneReparationDto = new LigneReparationDto();
        ligneReparationDto.setId(ligneReparation.getId());
        ligneReparationDto.setDate(ligneReparation.getDate());
       ligneReparationDto.setQuantite(ligneReparation.getQuantite());
       ligneReparationDto.setDate(ligneReparation.getDate());
       ligneReparationDto.setProduitDto(produitService.produitToDto(ligneReparation.getProduit())); // Assuming a ProduitService
        return ligneReparationDto;
    }

        public LigneReparation  dtoToLigneFacture(LigneReparationDto lignefactureDto) {
        if (lignefactureDto == null) {
            return null;
        }
        LigneReparation ligneReparation = new LigneReparation();
        ligneReparation.setQuantite(lignefactureDto.getQuantite());
        ligneReparation.setDate(lignefactureDto.getDate());
        ligneReparation.setProduit(produitService.dtoToProduit(lignefactureDto.getProduitDto())); // Assuming a ProduitService
        return ligneReparation;
    }

    }