package com.odji.spring_back_end.services;

import com.odji.spring_back_end.dto.ProduitDto;
import com.odji.spring_back_end.model.Produit;
import com.odji.spring_back_end.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

    @Service
    public class ProduitService {

        private final ProduitRepository produitRepository;
        private final CategorieService categorieService;
        private final MagasinService magasinService;

        public ProduitService(ProduitRepository produitRepository, CategorieService categorieService, MagasinService magasinService) {
            this.produitRepository = produitRepository;
            this.categorieService = categorieService;
            this.magasinService = magasinService;
        }

        // You can add other service dependencies for LigneFactureDto, etc. if needed

        public List<ProduitDto> produitDtoList(List<Produit> produits) {
            return produits.stream()
                    .map(this::produitToDto) // Utilise la méthode de conversion individuelle
                    .collect(Collectors.toList());
        }

        public ProduitDto produitToDto(Produit produit) {
            if (produit == null) {
                return null;
            }

            ProduitDto produitDto = new ProduitDto();
            produitDto.setId(produit.getId());
            produitDto.setCodeproduit(produit.getCodeproduit());
            produitDto.setNom(produit.getNom());
            produitDto.setDesignation(produit.getDesignation());
            produitDto.setQuantite(produit.getQuantite());
            produitDto.setPrixAchat(produit.getPrixAchat());
            produitDto.setCategorieDto(categorieService.categorieToDto(produit.getCategorie()));
            //produitDto.setMagasinDto(magasinService.magasinToDto(produit.getMagasin()));

            return produitDto;
        }

        public Produit dtoToProduit(ProduitDto produitDto) {
            if (produitDto == null) {
                return null;
            }

            Produit produit = new Produit();
            produit.setId(produitDto.getId());
            produit.setCodeproduit(produitDto.getCodeproduit());
            produit.setNom(produitDto.getNom());
            produit.setDesignation(produitDto.getDesignation());
            produit.setQuantite(produitDto.getQuantite());
            produit.setPrixAchat(produitDto.getPrixAchat());
            produit.setCategorie(categorieService.dtoToCategorie(produitDto.getCategorieDto()));
            //produit.setMagasin(magasinService.dtoToMagasin(produitDto.getMagasinDto())); // Assuming magasinService exists
            // Similar logic for other properties (avarie, lignefacture, etc.)
            return produit;
        }


        public List<ProduitDto> getProduitsSansAvarie() {
            List<Produit> produits = produitRepository.findAllWithoutAvarie();
            return produits.stream()
                    .map(this::produitToDto)
                    .collect(Collectors.toList());
        }
    }








