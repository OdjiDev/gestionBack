package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.PersonelDto;
import com.odji.spring_back_end.model.Personel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonelService {

    private final OptionService optionService;
    public List<PersonelDto> personelDtoList(List<Personel> personels){
        return personels.stream()
                .map(this::personelToDto) //utilise la methode de conversion individuel
                .collect(Collectors.toList());

    }
    public PersonelDto personelToDto(Personel personel) {
        if (personel == null) {
            return null;
        }

        PersonelDto personelDto = new PersonelDto();
        personelDto.setId(personel.getId());
        personelDto.setNom(personel.getNom());
        personelDto.setPrenom(personel.getPrenom());
        personelDto.setDateDeNaissance(personel.getDateDeNaissance());
        personelDto.setLieuDeNaissance(personel.getLieuDeNaissance());
        personelDto.setNumero(personel.getNumero());
        personelDto.setEmail(personel.getEmail());
        personelDto.setSexe(personel.getSexe());
        personelDto.setRole(optionService.OptionToDto(personel.getRole()));
        return personelDto;
    }
    public  Personel dtoToPersonel(PersonelDto personelDto) {
        if (personelDto== null) {
            return null;
        }

        Personel personel= new Personel();
        personel.setId(personelDto.getId());
        personel.setNom(personelDto.getNom());
        personel.setPrenom(personelDto.getPrenom());
        personel.setLieuDeNaissance(personelDto.getLieuDeNaissance());
        personel.setDateDeNaissance(personelDto.getDateDeNaissance());
        personel.setRole(optionService.dtoToOption(personelDto.getRole()));
        personel.setSexe(personelDto.getSexe());
        personel.setEmail(personelDto.getEmail());
        personel.setNumero(personelDto.getNumero());


        return personel;
    }

}
