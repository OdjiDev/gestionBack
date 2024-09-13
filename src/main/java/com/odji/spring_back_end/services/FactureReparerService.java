package com.odji.spring_back_end.services;
import com.odji.spring_back_end.dto.AvarieDto;
import com.odji.spring_back_end.dto.FactureReparerDto;
import com.odji.spring_back_end.model.Avarie;
import com.odji.spring_back_end.model.FactureReparer;
import com.odji.spring_back_end.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FactureReparerService {

    public List<FactureReparerDto> factureReparerDtoList(List<FactureReparer> factureReparer) {
        return factureReparer.stream()
                .map(this::factureReparerToDto) // Utilise la méthode de conversion individuelle
                .collect(Collectors.toList());
    }
   FactureReparerDto factureReparerToDto(FactureReparer facturereparer) {
        if (facturereparer == null) {
            return null;
        }
      FactureReparerDto facturereparerDto = new FactureReparerDto();
       facturereparerDto.setId(facturereparer.getId());
       facturereparerDto.setCode(facturereparer.getCode());
       facturereparerDto.setDate(facturereparer.getDate());

        return facturereparerDto;
    }

    public FactureReparer dtoToFactureReparer(FactureReparerDto factureReparerDto) {
        if (factureReparerDto == null) {
            return null;
        }
       FactureReparer factureReparer = new FactureReparer();
       factureReparer.setId(factureReparerDto.getId());
       factureReparer.setCode(factureReparerDto.getCode());
       factureReparer.setDate(factureReparerDto.getDate());

        return factureReparer;
    }
}
