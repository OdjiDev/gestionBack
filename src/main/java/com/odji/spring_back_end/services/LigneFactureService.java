package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.AvarieDto;
import com.odji.spring_back_end.dto.LigneFactureDto;
import com.odji.spring_back_end.model.Avarie;
import com.odji.spring_back_end.model.LigneFacture;
import com.odji.spring_back_end.repository.LigneFactureRepository;
import com.odji.spring_back_end.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LigneFactureService {
    private final ProduitService produitService;
    private final FactureService factureService;


    private final LigneFactureRepository ligneFactureRepository; // Assuming a repository for persistence

    public List<LigneFactureDto> LigneFactureDtoList(List< LigneFacture > ligneFactures) {
        return ligneFactures.stream()
                .map(this::ligneFactureToDto)
                .collect(Collectors.toList());
    }
    public LigneFactureDto ligneFactureToDto(LigneFacture ligneFacture) {
        if (ligneFacture == null) {
            return null;
        }
        LigneFactureDto lignefactureDto = new LigneFactureDto();
        lignefactureDto.setId(ligneFacture.getId());
       lignefactureDto.setQuantite(ligneFacture.getQuantite());
        lignefactureDto.setDate(ligneFacture.getDate());

        lignefactureDto.setProduitDto(produitService.produitToDto(ligneFacture.getProduit())); // Assuming a ProduitService
        lignefactureDto.setFactureDto(factureService.factureToDto(ligneFacture.getFacture())); // Assuming a FactureService

        return lignefactureDto;
    }

        public LigneFacture dtoToLignefacture(LigneFactureDto lignefactureDto) {
        if (lignefactureDto== null) {
            return null;
        }
        LigneFacture ligneFacture = new LigneFacture();
        ligneFacture.setId(lignefactureDto.getId());
        ligneFacture.setQuantite(lignefactureDto.getQuantite());
        ligneFacture.setDate(lignefactureDto.getDate());

        ligneFacture.setProduit(produitService.dtoToProduit(lignefactureDto.getProduitDto())); // Assuming a ProduitService
        ligneFacture.setFacture(factureService.dtoToFacture(lignefactureDto.getFactureDto())); // Assuming a FactureService

        return ligneFacture;
    }

    // ... other methods as needed
}

