package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.MvtStkDto;
import com.odji.spring_back_end.model.MvtStk;
import com.odji.spring_back_end.model.Produit;
import com.odji.spring_back_end.repository.MvtStkRepository;
import com.odji.spring_back_end.repository.ProduitRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MvtStkService {

    private final ProduitService produitService;
 //   private  final mvtStkS

    private final MvtStkRepository mvtStkRepository;
    private final ProduitRepository produitRepository;

//ajout de stock
@Transactional
    public MvtStk ajouterMouvementDeStock(MvtStk mvtStk) {
        if (mvtStk.getProduit() == null || mvtStk.getProduit().getId() == null) {
            throw new IllegalArgumentException("Le mouvement de stock doit être associé à un produit.");
        }

        // Vérifie si le produit existe
        Produit produit = produitRepository.findById(mvtStk.getProduit().getId())
                .orElseThrow(() -> new IllegalArgumentException("Le produit n'existe pas."));

        // Mise à jour du mouvement de stock
        mvtStk.setProduit(produit);
        mvtStkRepository.save(mvtStk);

        // Mise à jour de la quantité du produit
        BigDecimal quantiteActuelle = produit.getQuantite() != null ? produit.getQuantite() : BigDecimal.ZERO;
        BigDecimal nouvelleQuantite = quantiteActuelle.add(mvtStk.getQuantite() != null ? mvtStk.getQuantite() : BigDecimal.ZERO);
        produit.setQuantite(nouvelleQuantite);
        produitRepository.save(produit);
        return mvtStk;
    }

   // reduction de stock


    @Transactional
    public MvtStk reduireMouvementDeStock(MvtStk mvtStk) {
        // Vérifie si le mouvement de stock est associé à un produit
        Produit produit = produitRepository.findById(Optional.ofNullable(mvtStk.getProduit())
                        .map(Produit::getId)
                        .orElseThrow(() -> new IllegalArgumentException("Le mouvement de stock doit être associé à un produit.")))
                .orElseThrow(() -> new IllegalArgumentException("Le produit n'existe pas."));

        // Mise à jour du mouvement de stock
        mvtStk.setProduit(produit);
        mvtStkRepository.save(mvtStk);

        // Réduction de la quantité du produit
        BigDecimal quantiteActuelle = Optional.ofNullable(produit.getQuantite()).orElse(BigDecimal.ZERO);
        BigDecimal quantiteMouvement = Optional.ofNullable(mvtStk.getQuantite()).orElse(BigDecimal.ZERO);

        // Vérifie si la réduction ne dépasse pas la quantité actuelle
        if (quantiteMouvement.compareTo(quantiteActuelle) > 0) {
            throw new IllegalArgumentException("La quantité à réduire dépasse la quantité actuelle du stock.");
        }

        BigDecimal nouvelleQuantite = quantiteActuelle.subtract(quantiteMouvement);
        produit.setQuantite(nouvelleQuantite);
        produitRepository.save(produit);

        return mvtStk;
    }

    public List<MvtStkDto> mvtStkDtoList(List<MvtStk> mvtStks){
        return mvtStks.stream()
                .map(this::mvtStkToDto) //utilise la methode de conversion individuel
                .collect(Collectors.toList());

    }
    public MvtStkDto mvtStkToDto(MvtStk mvtStk) {
        if (mvtStk == null) {
            return null;
        }

        MvtStkDto mvtStkDto = new MvtStkDto();
        mvtStkDto.setId(mvtStk.getId());
        mvtStkDto.setQuantite(mvtStk.getQuantite());
        mvtStkDto.setPrixAchat(mvtStk.getPrixAchat());
        mvtStkDto.setDate(mvtStk.getDate());
        mvtStkDto.setProduitDto(produitService.produitToDto(mvtStk.getProduit()));

        return mvtStkDto;
    }

    public MvtStk dtoToMvtStk(MvtStkDto mvtStkDto) {
        if (mvtStkDto == null) {
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setQuantite(mvtStkDto.getQuantite());
        mvtStk.setPrixAchat(mvtStkDto.getPrixAchat());
        mvtStk.setDate(mvtStkDto.getDate());
        mvtStk.setProduit(produitService.dtoToProduit(mvtStkDto.getProduitDto()));

        return mvtStk;
    }

}
