package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.OptionDto;
import com.odji.spring_back_end.model.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OptionService {

    private final ReparerService reparerService;

    public List<OptionDto> optionDtoList(List<Option> Option) {
        return Option.stream()
                .map(this::OptionToDto) // Utilise la méthode de conversion individuelle
                .collect(Collectors.toList());
    }


    public OptionDto OptionToDto(Option option) {
        if (option == null) {
            return null;
        }

        OptionDto roleDto = new OptionDto();
        roleDto.setId(option.getId());
        roleDto.setNom(option.getNom());



        return roleDto;
    }

    public Option dtoToOption(OptionDto roleDto) {
        if (roleDto == null) {
            return null;
        }

        Option option = new Option();
        option.setId(roleDto.getId());
        option.setNom(roleDto.getNom());


        return option;
    }


}