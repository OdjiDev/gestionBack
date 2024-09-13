package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.ContratDto;
import com.odji.spring_back_end.model.Contrat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContratService {

        private  final SocieteService societeService;


        public List<ContratDto> contratDtoList(List<Contrat> contrats){
            return contrats.stream()
                    .map(this::contratToDto) //utilise la methode de conversion individuel
                    .collect(Collectors.toList());

        }


        public ContratDto contratToDto(Contrat contrat) {
            if (contrat == null) {
                return null;
            }

            ContratDto contratDto = new ContratDto();
            contratDto.setId(contrat.getId());
            contratDto.setCode(contrat.getCode());
            contratDto.setNom(contratDto.getNom());
            contratDto.setDatedefin(contrat.getDatedefin());
            contratDto.setDatedebut(contrat.getDatedebut());
            contratDto.setSocieteDto(societeService.societeToDto(contrat.getSociete()));


            return contratDto;
        }
        public Contrat dtoToContrat(ContratDto contratDto) {
            if (contratDto == null) {
                return null;
            }

            Contrat contrat = new Contrat();
            contrat.setId(contratDto.getId());
            contrat.setCode(contratDto.getCode());
            contrat.setNom(contratDto.getNom());
            contrat.setDatedebut(contratDto.getDatedebut());
            contrat.setDatedefin(contratDto.getDatedefin());
            contrat.setSociete(societeService.dtoToSociete(contratDto.getSocieteDto()));

            return contrat;
        }
    }



