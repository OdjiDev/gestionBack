package com.odji.spring_back_end.services;
import com.odji.spring_back_end.dto.AvarieDto;
import com.odji.spring_back_end.dto.LigneFactureReparerDto;
import com.odji.spring_back_end.model.Avarie;
import com.odji.spring_back_end.model.LigneFactureReparer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LigneFactureReparerService {
    private  final ProduitService produitService;
    private final FactureReparerService factureReparerService;
    private  final  ReparerService reparerService;

    public List<LigneFactureReparerDto> ligneFactureReparer(List<LigneFactureReparer> ligneFactureReparer) {
        return ligneFactureReparer.stream()
                .map(this::ligneFactureReparerToDto)
                .collect(Collectors.toList());
    }

//   public LigneFactureReparerDto ligneFactureReparerToDto(LigneFactureReparer ligneFactureReparer) {
//        if (ligneFactureReparer == null) {
//            return null;
//        }
//        LigneFactureReparerDto ligneFactureReparerDto = new LigneFactureReparerDto();
//        ligneFactureReparerDto.setId(ligneFactureReparer.getId());
//        ligneFactureReparerDto.setQuantite(ligneFactureReparer.getQuantite());
//        ligneFactureReparerDto.setDate(ligneFactureReparer.getDate());
//
//       // ligneFactureReparerDto.setProduitDto(produitService.produitToDto(ligneFactureReparer.getProduit())); // Assuming a ProduitService
//        ligneFactureReparerDto.setReparerDto(ReparerService.ReparerToDto(ligneFactureReparer.getReparer())); // Assuming a FactureService
//
//        return ligneFactureReparerDto;
//    }
//    public  LigneFactureReparer dtoToLigneFactureReparer(LigneFactureReparerDto lignefactureReparerDto) {
//        if (lignefactureReparerDto== null) {
//            return null;
//        }
//        LigneFactureReparer lignefactureReparer = new LigneFactureReparer();
//        lignefactureReparer.setId(lignefactureReparer.getId());
//       lignefactureReparer.setQuantite(lignefactureReparerDto.getQuantite());
//        lignefactureReparer.setDate(lignefactureReparerDto.getDate());
//
//        //lignefactureReparer.setProduit(produitService.dtoToProduit(lignefactureReparerDto.getLast().getProduitDto())); // Assuming a ProduitService
//       lignefactureReparer.setReparer(reparerService.dtoToReparer(lignefactureReparerDto.getReparerDto()));
//        lignefactureReparer.setFacturereparer(factureReparerService.dtoToFactureReparer(lignefactureReparerDto.getFacturereparerDto())); // Assuming a FactureService
//        return lignefactureReparer;
//    }







    public LigneFactureReparerDto ligneFactureReparerToDto(LigneFactureReparer ligneFactureReparer) {
        if (ligneFactureReparer == null) {
            return null;
        }
        LigneFactureReparerDto ligneFactureReparerDto = new LigneFactureReparerDto();
        ligneFactureReparerDto.setId(ligneFactureReparer.getId());
        ligneFactureReparerDto.setQuantite(ligneFactureReparer.getQuantite());
        ligneFactureReparerDto.setDate(ligneFactureReparer.getDate());

        ligneFactureReparerDto.setProduitDto(produitService.produitToDto(ligneFactureReparer.getProduit())); // Assuming a ProduitService
        ligneFactureReparerDto.setReparerDto(reparerService.ReparerToDto(ligneFactureReparer.getReparer())); // Assuming a FactureService

        return ligneFactureReparerDto;
    }

    public LigneFactureReparer dtoToLigneFactureReparer(LigneFactureReparerDto lignefactureReparerDto) {
        if (lignefactureReparerDto == null) {
            return null;
        }
        LigneFactureReparer lignefactureReparer = new LigneFactureReparer();
        lignefactureReparer.setId(lignefactureReparerDto.getId());
        lignefactureReparer.setQuantite(lignefactureReparerDto.getQuantite());
        lignefactureReparer.setDate(lignefactureReparerDto.getDate());

        lignefactureReparer.setProduit(produitService.dtoToProduit(lignefactureReparerDto.getProduitDto())); // Assuming a ProduitService
        lignefactureReparer.setReparer(reparerService.dtoToReparer(lignefactureReparerDto.getReparerDto()));
        lignefactureReparer.setFacturereparer(factureReparerService.dtoToFactureReparer(lignefactureReparerDto.getFacturereparerDto())); // Assuming a FactureService
        return lignefactureReparer;
    }
}





