package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.BureauDto;
import com.odji.spring_back_end.dto.DemandeDto;
import com.odji.spring_back_end.model.Demande;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DemandeService {

    private  final LigneDemandeService ligneDemandeService;
    private final BureauService bureauService;
    private  final PersonelService personelService;

    public List<DemandeDto> demandesDtoList(List<Demande> demandes){
        return demandes.stream()
    .map(this::demandeToDto) //utilise la methode de conversion individuel
                .collect(Collectors.toList());

    }


    public DemandeDto demandeToDto(Demande demande) {
        if (demande == null) {
            return null;
        }

        DemandeDto demandeDto = new DemandeDto();
        demandeDto.setId(demande.getId());
        demandeDto.setMotif(demande.getMotif());
        demandeDto.setLignedemandeDto(ligneDemandeService.LigneDemandeToDto(demande.getLignedemande()));
        demandeDto.setBureauDto(bureauService.BureauToDto(demande.getBureau()));
        demandeDto.setPersonelDto(personelService.personelToDto(demande.getPersonel()));
        return demandeDto;

    }
    public Demande dtoToDemande(DemandeDto demandeDto) {
        if (demandeDto == null) {
            return null;
        }

        Demande demande = new Demande();
        demande.setId(demandeDto.getId());
        demande.setMotif(demandeDto.getMotif());
        demande.setLignedemande(ligneDemandeService.dtoToLigneDemande(demandeDto.getLignedemandeDto()));
        demande.setPersonel(personelService.dtoToPersonel(demandeDto.getPersonelDto()));
        return demande;
    }
}
