package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.LigneDemandeDto;
import com.odji.spring_back_end.dto.LigneDemandeDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.LigneDemande;
import com.odji.spring_back_end.model.Demande;
import com.odji.spring_back_end.model.LigneDemande;
import com.odji.spring_back_end.repository.LigneDemandeRepository;
import com.odji.spring_back_end.repository.LigneDemandeRepository;
import com.odji.spring_back_end.services.LigneDemandeService;
import com.odji.spring_back_end.services.LigneDemandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "https://odjidev.github.io")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LigneDemandeController {

   

        private final LigneDemandeRepository ligneDemandeRepository;
        private final LigneDemandeService ligneDemandeService;

        // get all ligneDemande
        @GetMapping("/ligneDemandes/list")
        public List<LigneDemandeDto> getAllLigneDemandes() {
            List<LigneDemande> ligneDemandes = ligneDemandeRepository.findAll(); // Assuming you have a JPA repository named 'produitRepository'
            return ligneDemandeService.LigneDemandeDtoList(ligneDemandeRepository.findAll()); // Convert products to DTOs
        }
        // create ligneDemandes
        @PostMapping("ligneDemandes")
        public ResponseEntity<LigneDemandeDto> createLigneDemande(@RequestBody LigneDemandeDto ligneDemandeDto) {
            LigneDemande ligneDemande = ligneDemandeService.dtoToLigneDemande(ligneDemandeDto);
            LigneDemande savedLigneDemande = ligneDemandeRepository.save(ligneDemande);
            return ResponseEntity.ok(ligneDemandeService.LigneDemandeToDto(savedLigneDemande));
        }
        //get ligneDemande by id
        @GetMapping("ligneDemandes/{id}")
        public ResponseEntity<LigneDemande> getLigneDemandeById(@PathVariable Integer id) {
            Optional<LigneDemande> optionalLigneDemande = ligneDemandeRepository.findById(id);

            if (optionalLigneDemande.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(optionalLigneDemande.get());
        }
        //
        // Update a category
        @PutMapping("ligneDemandes/{id}")
        public ResponseEntity<LigneDemandeDto> updateLigneDemande(@PathVariable Integer id, @RequestBody LigneDemandeDto ligneDemandeDetailsDto) {
            ligneDemandeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("LigneDemande not found with id: " + id));
            LigneDemande updateLigneDemande;

            updateLigneDemande = ligneDemandeService.dtoToLigneDemande(ligneDemandeDetailsDto);
            updateLigneDemande.setId(id);
            ligneDemandeDetailsDto=ligneDemandeService.LigneDemandeToDto(ligneDemandeRepository.save(updateLigneDemande));
            return ResponseEntity.ok( ligneDemandeDetailsDto);
        }

        // build delete inscription REST API
        @DeleteMapping("ligneDemandes/{id}")
        public ResponseEntity<HttpStatus> deleteLigneDemande(@PathVariable Integer id){

            LigneDemande ligneDemande = ligneDemandeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("ligneDemande  not exist with id: " + id));

            ligneDemandeRepository.delete(ligneDemande);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

    }
