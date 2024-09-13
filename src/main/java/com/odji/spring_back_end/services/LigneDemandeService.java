package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.AvarieDto;
import com.odji.spring_back_end.dto.LigneDemandeDto;
import com.odji.spring_back_end.model.Avarie;
import com.odji.spring_back_end.model.LigneDemande;
import com.odji.spring_back_end.model.LigneFacture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class LigneDemandeService {
    private  final ProduitService produitService;

    public List<LigneDemandeDto> LigneDemandeDtoList(List<LigneDemande> ligneDemandes) {
        return ligneDemandes.stream()
                .map(this::LigneDemandeToDto)
                .collect(Collectors.toList());
    }

    public LigneDemandeDto LigneDemandeToDto(LigneDemande ligneDemande) {
        if (ligneDemande == null) {
            return null;
        }
        LigneDemandeDto ligneDemandeDto = new LigneDemandeDto();
        ligneDemandeDto.setId(ligneDemande.getId());
        ligneDemandeDto.setQuantite(ligneDemande.getQuantite());
        ligneDemandeDto.setDate(ligneDemande.getDate());
        ligneDemandeDto.setProduit(produitService.produitToDto(ligneDemande.getProduit())); // Assuming a ProduitService
        return ligneDemandeDto;
    }

    public LigneDemande dtoToLigneDemande(LigneDemandeDto ligneDemandeDto) {
        if (ligneDemandeDto == null) {
            return null;
        }
        LigneDemande ligneDemande = new LigneDemande();
        ligneDemande.setId(ligneDemandeDto.getId()); // Set the ID
        ligneDemande.setQuantite(ligneDemandeDto.getQuantite());
        ligneDemande.setDate(ligneDemandeDto.getDate());
        ligneDemande.setProduit(produitService.dtoToProduit(ligneDemandeDto.getProduit())); // Assuming a ProduitService
        return ligneDemande;
    }

    // ... other methods as needed
}

