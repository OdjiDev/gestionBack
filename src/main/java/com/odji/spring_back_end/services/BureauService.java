package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.BureauDto;
import com.odji.spring_back_end.dto.DemandeDto;
import com.odji.spring_back_end.dto.DepartementDto;
import com.odji.spring_back_end.model.Bureau;
import com.odji.spring_back_end.model.Demande;
import com.odji.spring_back_end.model.Bureau;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BureauService {


        public List<BureauDto> bureausDtoList(List< Bureau > bureau) {
            return bureau.stream()
                    .map(this::BureauToDto) //utilise la methode de conversion individuel
                    .collect(Collectors.toList());
        }

            public BureauDto BureauToDto(Bureau  bureau) {
        if (bureau == null) {
            return null;
        }

        BureauDto bureauDto = new BureauDto();
        bureauDto.setId(bureau.getId());
        bureauDto.setNom(bureau.getNom());
        return bureauDto;
    }
    public Bureau dtoToBureau(BureauDto bureauDto) {
        if (bureauDto== null) {
            return null;
        }

        Bureau bureau= new Bureau();
        bureau.setId(bureauDto.getId());
        bureau.setNom(bureauDto.getNom());

        return bureau;
    }
}
