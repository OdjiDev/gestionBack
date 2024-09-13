package com.odji.spring_back_end.controller;


import com.odji.spring_back_end.dto.LigneFactureDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Facture;
import com.odji.spring_back_end.model.Produit;

import com.odji.spring_back_end.model.LigneFacture;
import com.odji.spring_back_end.repository.ProduitRepository;
import com.odji.spring_back_end.repository.FactureRepository;
import com.odji.spring_back_end.repository.LigneFactureRepository;
import com.odji.spring_back_end.repository.FactureRepository;

import com.odji.spring_back_end.services.FactureService;
import com.odji.spring_back_end.services.LigneFactureService;
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
public class LigneFactureController {
 

        private final LigneFactureRepository lignefactureRepository;
        @Autowired
        private  final LigneFactureService lignefactureService;
        private final FactureRepository factureRepository;
        private  final ProduitRepository produitRepository;



        // build create lignefacture REST API
        @PostMapping("/lignefactures")
        public LigneFactureDto createLigneFacture(@RequestBody LigneFactureDto lignefactureDto) {
            LigneFacture lignefacture= lignefactureService.dtoToLignefacture(lignefactureDto);
             Integer factureId= lignefactureDto.getFactureDto().getId();
             Optional<Facture> existingFactureOptional= factureRepository.findById(factureId);

            //Verification de l'existance du facture
        if(existingFactureOptional.isPresent()){
            // Si facture est trouvé l'affecter  au lignefacture
           lignefacture.setFacture(existingFactureOptional.get());
        }

            Integer produitId= lignefactureDto.getProduitDto().getId();
            Optional<Produit> existingProduitOptional= produitRepository.findById(produitId);

            //Verification de l'existance de la produit
            if(existingProduitOptional.isPresent()){
                // Si  la produit est trouvé l'affecter  au lignefacture
                lignefacture.setProduit(existingProduitOptional.get());
            }

            // enrégistrement du lignefacture dans la base de donnée
            lignefactureDto= lignefactureService.ligneFactureToDto(lignefactureRepository.save(lignefacture));
            return lignefactureDto;
        }



// build get all product

        @GetMapping("/lignefactures/list")
        // Replace placeholders with your actual logic for data access using DTOs
        public List<LigneFactureDto> getAllLigneFactures() {
            List<LigneFacture> lignefactures = lignefactureRepository.findAll(); // Assuming you have a JPA repository named 'lignefactureRepository'
            return lignefactureService.LigneFactureDtoList(lignefactureRepository.findAll()); // Convert products to DTOs
        }
        //           // build get product by id REST API
        //get product by id
        @GetMapping("/lignefactures/{id}")
        public ResponseEntity<LigneFactureDto> getDLigneFactureById(@PathVariable  Integer id){
            LigneFacture lignefacture = lignefactureRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("LigneFacture not exist with id:" + id));
            return ResponseEntity.ok(lignefactureService.ligneFactureToDto(lignefacture));
        }

        // build update LigneFacture REST API
        @PutMapping("/lignefactures/{id}")
        public ResponseEntity<LigneFactureDto> updateLigneFacture(@PathVariable Integer id,@RequestBody LigneFactureDto lignefactureDetailsDto) {
            LigneFacture updateLigneFacture = lignefactureRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("lignefacture not exist with id: " + id));
            updateLigneFacture = lignefactureService.dtoToLignefacture(lignefactureDetailsDto);
            updateLigneFacture.setId(id);
            lignefactureDetailsDto.setId(id);

            lignefactureDetailsDto= lignefactureService.ligneFactureToDto(lignefactureRepository.save(updateLigneFacture));

            return ResponseEntity.ok(lignefactureDetailsDto);
        }



        // build delete demande REST API
        @DeleteMapping("/lignefactures/{id}")
        public ResponseEntity<HttpStatus> deleteLigneFacture(@PathVariable Integer id){

            LigneFacture lignefacture = lignefactureRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("LigneFacture not exist with id: " + id));

            lignefactureRepository.delete(lignefacture);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }



    }


