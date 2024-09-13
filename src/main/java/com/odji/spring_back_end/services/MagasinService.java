package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.MagasinDto;
import com.odji.spring_back_end.model.Avarie;
import com.odji.spring_back_end.model.Magasin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MagasinService {

    public List<MagasinDto> magasins(List<Magasin> magasins) {
        return magasins.stream()
                .map(this::magasinToDto) // Utilise la méthode de conversion individuelle
                .collect(Collectors.toList());
    }

    public MagasinDto magasinToDto(Magasin magasin) {
        if (magasin == null) {
            return null;
        }

        MagasinDto magasinDto = new MagasinDto();
        magasinDto.setId(magasin.getId());
        magasinDto.setNom(magasin.getNom());
        return magasinDto;
    }

    public Magasin dtoToMagasin(MagasinDto magasinDto) {
        if (magasinDto == null) {
            return null;
        }

        Magasin magasin = new Magasin();
        magasin.setId(magasinDto.getId());
        magasin.setNom(magasinDto.getNom());

        return magasin;
    }
}

