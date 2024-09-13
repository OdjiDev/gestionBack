package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.ProduitDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Categorie;
import com.odji.spring_back_end.model.Magasin;
import com.odji.spring_back_end.model.Produit;
import com.odji.spring_back_end.repository.CategorieRepository;
import com.odji.spring_back_end.repository.MagasinRepository;
import com.odji.spring_back_end.repository.ProduitRepository;
import com.odji.spring_back_end.services.CategorieService;
import com.odji.spring_back_end.services.MagasinService;
import com.odji.spring_back_end.services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
    public class ProduitController {
            private final ProduitRepository produitRepository;
            private  final ProduitService produitService;
            private  final CategorieRepository categorieRepository;



    // build create produit REST API
    @PostMapping("/produits")
    public ProduitDto createProduit(@RequestBody ProduitDto produitDto) {
       Produit produit= produitService.dtoToProduit(produitDto);

        Integer categorieId= produitDto.getCategorieDto().getId();
        Optional<Categorie> existingCategorieOptional= categorieRepository.findById(categorieId);

        //Verification de l'existance de la categorie
        if(existingCategorieOptional.isPresent()){
            // Si  la categorie est trouvé l'affecter  au produit
            produit.setCategorie(existingCategorieOptional.get());
        }

        // enrégistrement du produit dans la base de donnée
        produitDto= produitService.produitToDto(produitRepository.save(produit));
        return produitDto;
    }

    @GetMapping("/produits/sans-avarie")
    public List<ProduitDto> getProduitsSansAvarie() {
        return produitService.getProduitsSansAvarie();
    }


// build get all product

    @GetMapping("/produits/list")
                        public List<ProduitDto> getAllProduits() {
                List<Produit> produits = produitRepository.findAll(); // Assuming you have a JPA repository named 'produitRepository'
                return produitService.produitDtoList(produitRepository.findAll()); // Convert products to DTOs
            }

          // build get product by id REST API
         @GetMapping("/produits/{id}")
    public ResponseEntity<ProduitDto> getDProduitById(@PathVariable  Integer id){
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit not exist with id:" + id));
        return ResponseEntity.ok(produitService.produitToDto(produit));
    }

    // build update Produit REST API
    @PutMapping("/produits/{id}")
    public ResponseEntity<ProduitDto> updateProduit(@PathVariable Integer id,@RequestBody ProduitDto produitDetailsDto) {
        Produit updateProduit = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("produit not exist with id: " + id));
        updateProduit = produitService.dtoToProduit(produitDetailsDto);
        updateProduit.setId(id);

        produitDetailsDto= produitService.produitToDto(produitRepository.save(updateProduit));

        return ResponseEntity.ok(produitDetailsDto);
    }



    // build delete demande REST API
    @DeleteMapping("/produits/{id}")
    public ResponseEntity<HttpStatus> deleteProduit(@PathVariable Integer id){
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit not exist with id: " + id));

      produitRepository.delete(produit);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }



}
