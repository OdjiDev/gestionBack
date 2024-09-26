package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.SocieteDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Societe;
import com.odji.spring_back_end.repository.SocieteRepository;
import com.odji.spring_back_end.repository.PersonelRepository;
import com.odji.spring_back_end.repository.SocieteRepository;
import com.odji.spring_back_end.services.SocieteService;
import com.odji.spring_back_end.services.SocieteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "https://odjidev.github.io/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class SocieteController {

    private  final SocieteService societeService;
    private final SocieteRepository societeRepository;
    


    // get all societe
    @GetMapping("societes/list")
    public List<SocieteDto> getAllSocietes() {
        List<Societe> societes = societeRepository.findAll(); // Assuming you have a JPA repository named 'produitRepository'
        return societeService.societeDtoList(societeRepository.findAll()); // Convert products to DTOs
    }

    // create societes
    @PostMapping("societes")
    public ResponseEntity<SocieteDto> createSociete(@RequestBody SocieteDto societeDto) {
        Societe societe = societeService.dtoToSociete(societeDto);
        Societe savedSociete = societeRepository.save(societe);
        return ResponseEntity.ok(societeService.societeToDto(savedSociete));
    }

    //get societe by id
    @GetMapping("societes/{id}")
    public ResponseEntity<Societe> getSocieteById(@PathVariable Integer id) {
        Optional<Societe> optionalSociete = societeRepository.findById(id);

        if (optionalSociete.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalSociete.get());
    }
    // Update a category
    @PutMapping("societes/{id}")
    public ResponseEntity<SocieteDto> updateSociete(@PathVariable Integer id, @RequestBody SocieteDto societeDetailsDto) {
        societeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Societe not found with id: " + id));
        Societe updateSociete;

        updateSociete = societeService.dtoToSociete(societeDetailsDto);
        updateSociete.setId(id);
        societeDetailsDto=societeService.societeToDto(societeRepository.save(updateSociete));
        return ResponseEntity.ok( societeDetailsDto);
    }

    // build delete inscription REST API
    @DeleteMapping("societes/{id}")
    public ResponseEntity<HttpStatus> deleteSociete(@PathVariable Integer id){

        Societe societe = societeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("societe  not exist with id: " + id));

        societeRepository.delete(societe);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
