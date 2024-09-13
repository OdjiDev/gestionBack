package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.SuivieDto;
import com.odji.spring_back_end.model.Suivie;
import com.odji.spring_back_end.repository.SuivieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SuivieService {

    private final SuivieRepository suivieRepository;
    private final ProduitService produitService;
    private final PersonelService personelService;
    private  final BureauService bureauService;


    // You can add other service dependencies for LigneFactureDto, etc. if needed

    public List<SuivieDto> suivieDtoList(List<Suivie> suivies) {
        return suivies.stream()
                .map(this::suivieToDto) // Utilise la méthode de conversion individuelle
                .collect(Collectors.toList());
    }

    public SuivieDto suivieToDto(Suivie suivie) {
        if (suivie == null) {
            return null;
        }

        SuivieDto suivieDto = new SuivieDto();
        suivieDto.setId(suivie.getId());
        suivieDto.setCode(suivie.getCode());
        suivieDto.setNumero(suivie.getNumero());
        suivieDto.setDesignation(suivie.getDesignation());
        suivieDto.setDesignation(suivie.getDesignation());
        suivieDto.setDate(suivie.getDate());
        suivieDto.setEtat(suivie.getEtat());
        suivieDto.setNomComplet(suivie.getNomComplet());
        suivieDto.setTypeSuivie(suivie.getTypeSuivie());
        suivieDto.setProduitDto(produitService.produitToDto(suivie.getProduit()));
       // suivieDto.setBureauDto(bureauService.BureauToDto(suivie.getBureau()));
        suivieDto.setPersonelDto(personelService.personelToDto(suivie.getPersonel()));
       // suivieDto.pr(categorieService.categorieToDto(suivie.getCategorie()));
        //suivieDto.setMagasinDto(magasinService.magasinToDto(suivie.getMagasin()));

        return suivieDto;
    }

    public Suivie dtoToSuivie(SuivieDto suivieDto) {
        if (suivieDto == null) {
            return null;
        }

        Suivie suivie = new Suivie();
        suivie.setId(suivieDto.getId());
        suivie.setCode(suivieDto.getCode());
        suivie.setNumero(suivieDto.getNumero());
        suivie.setDesignation(suivieDto.getDesignation());
        suivie.setDate(suivieDto.getDate());
        suivie.setTypeSuivie(suivieDto.getTypeSuivie());
        suivie.setEtat(suivieDto.getEtat());
        suivie.setNomComplet(suivieDto.getNomComplet());
        suivie.setTypeSuivie(suivieDto.getTypeSuivie());
        suivie.setProduit(produitService.dtoToProduit(suivieDto.getProduitDto()));
        suivie.setPersonel(personelService.dtoToPersonel(suivieDto.getPersonelDto())); // Assuming  Similar logic for other properties (avarie, lignefacture, etc.)
      //  suivie.setBureau(bureauService.dtoToBureau(suivieDto.getBureauDto())); // Assuming magasin

        return suivie;
    }

//
//    public List<SuivieDto> getSuiviesSansAvarie() {
//        List<Suivie> suivies = suivieRepository.findAllWithoutAvarie();
//        return suivies.stream()
//                .map(this::suivieToDto)
//                .collect(Collectors.toList());
//    }
//}

}
