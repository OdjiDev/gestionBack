package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.ProduitDto;
import com.odji.spring_back_end.dto.ReparerDto;
import com.odji.spring_back_end.model.Produit;
import com.odji.spring_back_end.model.Reparer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReparerService {

    public List<ReparerDto> reparerDtoList(List<Reparer> Reparer) {
        return Reparer.stream()
                .map(this::ReparerToDto) // Utilise la méthode de conversion individuelle
                .collect(Collectors.toList());
    }

//    public ReparerDto ReparerToDto(Reparer reparer) {
//        if (reparer == null) {
//            return null;
//        }
//
//        ReparerDto reparerDto = new ReparerDto();
//        reparerDto.setId(reparer.getId());
//        reparerDto.setMotif(reparer.getMotif());
//        return reparerDto;
//
//    }

    public Reparer dtoToReparer(ReparerDto reparerDto) {
        if (reparerDto == null) {
            return null;
        }

        Reparer reparer = new Reparer();
        reparer.setId(reparerDto.getId());
        reparer.setMotif(reparer.getMotif());
        return reparer;
    }
    public ReparerDto ReparerToDto(Reparer reparer) {
        if (reparer == null) {
            return null;
        }

        ReparerDto reparerDto = new ReparerDto();
        reparerDto.setId(reparer.getId());
        reparerDto.setMotif(reparer.getMotif());
        reparerDto.setDate(reparer.getDate()); // Assuming a 'date' property in Reparer

        // Add conversion logic for other relevant properties here
        return reparerDto;
    }

}
