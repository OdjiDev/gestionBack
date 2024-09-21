package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.FournisseurDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Fournisseur;
import com.odji.spring_back_end.repository.FournisseurRepository;
import com.odji.spring_back_end.services.FournisseurService;
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
public class FournisseurController {

    private  final FournisseurService fournisseurService;
    private  final FournisseurRepository fournisseurRepository;
    // get all fournisseur
    @GetMapping("/fournisseurs/list")
    public List<FournisseurDto> getAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll(); // Assuming you have a JPA repository named 'produitRepository'
        return fournisseurService.fournisseurDtoList(fournisseurRepository.findAll()); // Convert products to DTOs
    }

    // create fournisseurs
    @PostMapping("fournisseurs")
    public ResponseEntity<FournisseurDto> createFournisseur(@RequestBody FournisseurDto fournisseurDto) {
        Fournisseur fournisseur = fournisseurService.dtoToFournisseur(fournisseurDto);
        Fournisseur savedFournisseur = fournisseurRepository.save(fournisseur);
        return ResponseEntity.ok(fournisseurService.fournisseurToDto(savedFournisseur));
    }

    //get fournisseur by id
    @GetMapping("fournisseurs/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable Integer id) {
        Optional<Fournisseur> optionalFournisseur = fournisseurRepository.findById(id);

        if (optionalFournisseur.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalFournisseur.get());
    }
    // Update a category
    @PutMapping("fournisseurs/{id}")
    public ResponseEntity<FournisseurDto> updateFournisseur(@PathVariable Integer id, @RequestBody FournisseurDto fournisseurDetailsDto) {
        fournisseurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found with id: " + id));
        Fournisseur updateFournisseur;

        updateFournisseur = fournisseurService.dtoToFournisseur(fournisseurDetailsDto);
        updateFournisseur.setId(id);
        fournisseurDetailsDto=fournisseurService.fournisseurToDto(fournisseurRepository.save(updateFournisseur));
        return ResponseEntity.ok( fournisseurDetailsDto);
    }

    // build delete inscription REST API
    @DeleteMapping("fournisseurs/{id}")
    public ResponseEntity<HttpStatus> deleteFournisseur(@PathVariable Integer id){

        Fournisseur fournisseur = fournisseurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("fournisseur  not exist with id: " + id));

        fournisseurRepository.delete(fournisseur);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
