package com.odji.spring_back_end.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odji.spring_back_end.model.Reparer;
import lombok.*;

import java.util.Date;
import java.util.List;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReparerDto {

    private Integer id;

    private String motif;
    private Date date;

    @JsonIgnore
    private List<LigneReparationDto> lignereparations ;

    @JsonIgnore
    private List<LigneFactureReparerDto>lignefactureReparers;


}
