package com.odji.spring_back_end.services;
import com.odji.spring_back_end.dto.SocieteDto;
import com.odji.spring_back_end.model.Magasin;
import com.odji.spring_back_end.model.Societe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SocieteService {


    public List<SocieteDto> societeDtoList(List<Societe> societes) {
        return societes.stream()
                .map(this::societeToDto) // Utilise la méthode de conversion individuelle
                .collect(Collectors.toList());
    }


    public SocieteDto societeToDto(Societe societe) {
        if (societe == null) {
            return null;
        }

        SocieteDto societeDto = new SocieteDto();
        societeDto.setId(societe.getId());
        societeDto.setNom(societe.getNom());
        societeDto.setAdresse(societe.getAdresse());
        societeDto.setNumerofiscal(societe.getNumerofiscal());
        return societeDto;
    }

    public Societe dtoToSociete(SocieteDto societeDto) {
        if (societeDto == null) {
            return null;
        }

        Societe societe = new Societe();
        societe.setId(societeDto.getId());
        societe.setNom(societeDto.getNom());
        societe.setAdresse(societeDto.getAdresse());
        societe.setNumerofiscal(societeDto.getNumerofiscal());

        return societe;
    }
}
