package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.CategorieDto;
import com.odji.spring_back_end.dto.FactureDto;
import com.odji.spring_back_end.dto.ProduitDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Categorie;
import com.odji.spring_back_end.model.Facture;
import com.odji.spring_back_end.model.Produit;
import com.odji.spring_back_end.repository.FactureRepository;
import com.odji.spring_back_end.services.FactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "https://odjidev.github.io/")
@RestController
@RequiredArgsConstructor
@ RequestMapping("/api")
public class FactureController {

    private  final FactureService factureService;
    private  final FactureRepository factureRepository;
    // get all facture
    @GetMapping("/factures/list")
    public List<FactureDto> getAllFactures() {
        List<Facture> factures = factureRepository.findAll(); // Assuming you have a JPA repository named 'factureRepository'
        return factureService.factureDtoList(factureRepository.findAll()); // Convert products to DTOs
    }

    // create factures
    @PostMapping("factures")
    public ResponseEntity<FactureDto> createFacture(@RequestBody FactureDto factureDto) {
        Facture facture = factureService.dtoToFacture(factureDto);
        Facture savedFacture = factureRepository.save(facture);
        return ResponseEntity.ok(factureService.factureToDto(savedFacture));
    }


        //get facture by id
    @GetMapping("factures/{id}")
    public ResponseEntity<Facture> getFactureById(@PathVariable Integer id) {
        Optional<Facture> optionalFacture = factureRepository.findById(id);

        if (optionalFacture.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalFacture.get());
    }
    // Update a category
    @PutMapping("factures/{id}")
    public ResponseEntity<FactureDto> updateFacture(@PathVariable Integer id, @RequestBody FactureDto factureDetailsDto) {
        factureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facture not found with id: " + id));
        Facture updateFacture;

        updateFacture = factureService.dtoToFacture(factureDetailsDto);
        updateFacture.setId(id);
        factureDetailsDto=factureService.factureToDto(factureRepository.save(updateFacture));
        return ResponseEntity.ok( factureDetailsDto);
    }

    // build delete inscription REST API
    @DeleteMapping("factures/{id}")
    public ResponseEntity<HttpStatus> deleteFacture(@PathVariable Integer id){

        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("facture  not exist with id: " + id));

        factureRepository.delete(facture);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
