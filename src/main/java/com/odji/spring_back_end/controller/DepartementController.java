package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.CategorieDto;
import com.odji.spring_back_end.dto.DepartementDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Categorie;
import com.odji.spring_back_end.model.Departement;
import com.odji.spring_back_end.repository.DepartementRepository;
import com.odji.spring_back_end.repository.PersonelRepository;
import com.odji.spring_back_end.services.DepartementService;
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
public class DepartementController {
    private  final DepartementService departementService;
    private final PersonelRepository personelRepository;
    private  final DepartementRepository departementRepository;


    // get all departement
    @GetMapping("/departements/list")
    public List<DepartementDto> getAllDepartements() {
        List<Departement> departements = departementRepository.findAll(); // Assuming you have a JPA repository named 'produitRepository'
        return departementService.departementDtoList(departementRepository.findAll()); // Convert products to DTOs
    }

    // create departements
    @PostMapping("departements")
    public ResponseEntity<DepartementDto> createDepartement(@RequestBody DepartementDto departementDto) {
        Departement departement = departementService.dtoToDepartement(departementDto);
        Departement savedDepartement = departementRepository.save(departement);
        return ResponseEntity.ok(departementService.departementToDto(savedDepartement));
    }

    //get departement by id
    @GetMapping("departements/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable Integer id) {
        Optional<Departement> optionalDepartement = departementRepository.findById(id);

        if (optionalDepartement.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalDepartement.get());
    }
    // Update a category
    @PutMapping("departements/{id}")
    public ResponseEntity<DepartementDto> updateDepartement(@PathVariable Integer id, @RequestBody DepartementDto departementDetailsDto) {
        departementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Departement not found with id: " + id));
        Departement updateDepartement;

        updateDepartement = departementService.dtoToDepartement(departementDetailsDto);
        updateDepartement.setId(id);
        departementDetailsDto=departementService.departementToDto(departementRepository.save(updateDepartement));
        return ResponseEntity.ok( departementDetailsDto);
    }

    // build delete inscription REST API
    @DeleteMapping("departements/{id}")
    public ResponseEntity<HttpStatus> deleteDepartement(@PathVariable Integer id){

        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("departement  not exist with id: " + id));

        departementRepository.delete(departement);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
