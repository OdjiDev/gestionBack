package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.AvarieDto;
import com.odji.spring_back_end.dto.AvarieDto;
import com.odji.spring_back_end.dto.CategorieDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Avarie;
import com.odji.spring_back_end.model.Avarie;
import com.odji.spring_back_end.model.Categorie;
import com.odji.spring_back_end.model.Produit;
import com.odji.spring_back_end.repository.AvarieRepository;
import com.odji.spring_back_end.repository.ProduitRepository;
import com.odji.spring_back_end.services.AvarieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AvarieController {

    private final AvarieService avarieService;

    private final AvarieRepository avarieRepository;
    private final ProduitRepository produitRepository;


    // create AVARIE
    @PostMapping("/avaries")
    public ResponseEntity<AvarieDto> createAvarie(@RequestBody AvarieDto avarieDto) {
        Avarie avarie = avarieService.dtoToAvarie(avarieDto);
        Avarie savedAvarie= avarieRepository.save(avarie);
        return ResponseEntity.ok(avarieService.avarieToDto(savedAvarie));
    }
    // get all Avarie
    @GetMapping("/avaries/list")
    public List<AvarieDto> getAllAvarie() {
        List<Avarie> avaries = avarieRepository.findAll(); // Assuming you have a JPA repository named 'produitRepository'
        return avarieService.avariesDtoList(avarieRepository.findAll()); // Convert products to DTOs
    }

    //get avarie by id
    @GetMapping("avaries/{id}")
    public ResponseEntity<Avarie> getAvarieById(@PathVariable Integer id) {
        Optional<Avarie> optionalAvarie = avarieRepository.findById(id);

        if (optionalAvarie.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalAvarie.get());
    }
    // Update a category
    @PutMapping("avaries/{id}")
    public ResponseEntity<AvarieDto> updateAvarie(@PathVariable Integer id, @RequestBody AvarieDto avarieDetailsDto) {
        avarieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avarie not found with id: " + id));
        Avarie updateAvarie;

        updateAvarie = avarieService.dtoToAvarie(avarieDetailsDto);
        updateAvarie.setId(id);
        avarieDetailsDto=avarieService.avarieToDto(avarieRepository.save(updateAvarie));
        return ResponseEntity.ok( avarieDetailsDto);
    }

    // build delete inscription REST API
    @DeleteMapping("avaries/{id}")
    public ResponseEntity<HttpStatus> deleteAvarie(@PathVariable Integer id){

        Avarie avarie = avarieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("avarie  not exist with id: " + id));

        avarieRepository.delete(avarie);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}


