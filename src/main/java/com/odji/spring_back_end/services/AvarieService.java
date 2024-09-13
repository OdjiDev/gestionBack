package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.AvarieDto;
import com.odji.spring_back_end.dto.ProduitDto;
import com.odji.spring_back_end.model.Avarie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvarieService {
    private  final ProduitService produitService;

    public List<AvarieDto> avariesDtoList(List<Avarie> avaries){
        return avaries.stream()
                .map(this::avarieToDto) //utilise la methode de conversion individuel
                .collect(Collectors.toList());
    }


    public  AvarieDto avarieToDto(Avarie avarie) {
        if (avarie == null) {
            return null;
        }

        AvarieDto avarieDto = new AvarieDto();
        avarieDto.setId(avarie.getId());
        avarieDto.setQuantite(avarie.getQuantite());
        avarieDto.setDate(avarie.getDate());
        avarieDto.setMotif(avarie.getMotif());
        avarieDto.setProduitDto(produitService.produitToDto(avarie.getProduit()));
        return avarieDto;

    }

    public  Avarie dtoToAvarie(AvarieDto avarieDto) {
        if (avarieDto== null) {
            return null;
        }
        Avarie avarie = new Avarie();
        avarie.setId(avarieDto.getId());
        avarie.setQuantite(avarieDto.getQuantite());
        avarie.setDate(avarieDto.getDate());
        avarie.setMotif(avarieDto.getMotif());
        avarie.setProduit(produitService.dtoToProduit(avarieDto.getProduitDto()));
        return avarie;
    }
}



