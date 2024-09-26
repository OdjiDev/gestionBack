package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.DemandeDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Demande;
import com.odji.spring_back_end.repository.DemandeRepository;
import com.odji.spring_back_end.repository.PersonelRepository;
import com.odji.spring_back_end.services.DemandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://odjidev.github.io")
@RestController
@RequiredArgsConstructor
@ RequestMapping("/api")
public class DemandeController {
    private  final DemandeService demandeService;
    private final PersonelRepository personelRepository;
    private  final DemandeRepository demandeRepository;


    // get all demande
    @GetMapping("/demandes/list")
    public List<DemandeDto> getAllDemandes() {
        List<Demande> demandes = demandeRepository.findAll(); // Assuming you have a JPA repository named 'produitRepository'
        return demandeService.demandesDtoList(demandeRepository.findAll()); // Convert products to DTOs
    }
    // create demandes
    @PostMapping("demandes")
    public ResponseEntity<DemandeDto> createDemande(@RequestBody DemandeDto demandeDto) {
        Demande demande = demandeService.dtoToDemande(demandeDto);
        Demande savedDemande = demandeRepository.save(demande);
        return ResponseEntity.ok(demandeService.demandeToDto(savedDemande));
    }
    //get demande by id
    @GetMapping("demandes/{id}")
    public ResponseEntity<Demande> getDemandeById(@PathVariable Integer id) {
        Optional<Demande> optionalDemande = demandeRepository.findById(id);

        if (optionalDemande.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalDemande.get());
    }
    // Update a category
    @PutMapping("demandes/{id}")
    public ResponseEntity<DemandeDto> updateDemande(@PathVariable Integer id, @RequestBody DemandeDto demandeDetailsDto) {
        demandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Demande not found with id: " + id));
        Demande updateDemande;

        updateDemande = demandeService.dtoToDemande(demandeDetailsDto);
        updateDemande.setId(id);
        demandeDetailsDto=demandeService.demandeToDto(demandeRepository.save(updateDemande));
        return ResponseEntity.ok( demandeDetailsDto);
    }

    // build delete inscription REST API
    @DeleteMapping("demandes/{id}")
    public ResponseEntity<HttpStatus> deleteDemande(@PathVariable Integer id){

        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("demande  not exist with id: " + id));

        demandeRepository.delete(demande);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
