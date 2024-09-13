package com.odji.spring_back_end.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.odji.spring_back_end.model.FactureReparer;
import lombok.*;

import java.time.Instant;
import java.util.List;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FactureReparerDto {

    private Integer id;

    private String code;

    private Instant date;

    private SocieteDto societeDto ;

    @JsonIgnore
    private List<LigneFactureReparerDto> lignefacturereparers;



}
