package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.FactureDto;
import com.odji.spring_back_end.model.Facture;
import com.odji.spring_back_end.repository.FactureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FactureService {
    private final FournisseurService fournisseurService; // Assuming a service for Fournisseur management

    public List<FactureDto> factureDtoList(List<Facture> factures) {
        return factures.stream()
                .map(this::factureToDto) // Utilise la méthode de conversion individuelle
                .collect(Collectors.toList());
    }
    public   FactureDto factureToDto(Facture facture) {
        if (facture == null) {
            return null;
        }
        FactureDto factureDto = new FactureDto();
        factureDto.setId(facture.getId());
        factureDto.setCode(facture.getCode());
        factureDto.setNumero(factureDto.getNumero());
        factureDto.setTotal(factureDto.getTotal());
      //  factureDto.setDatecommande(factureDto.getDatecommande());
        factureDto.setFournisseurDto(fournisseurService.fournisseurToDto(facture.getFournisseur()));

        return factureDto;
    }

    public Facture dtoToFacture(FactureDto factureDto) {
        if (factureDto == null) {
            return null;
        }
        Facture facture = new Facture();
        facture.setId(factureDto.getId());
        facture.setCode(factureDto.getCode());
        facture.setNumero(facture.getNumero());
        facture.setTotal(facture.getTotal());
        //facture.setDatecommande(facture.getDatecommande());
        facture.setFournisseur(fournisseurService.dtoToFournisseur(factureDto.getFournisseurDto()));


        return facture;
    }
}