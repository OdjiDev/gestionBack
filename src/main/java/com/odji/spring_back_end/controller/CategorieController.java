package com.odji.spring_back_end.controller;
import com.odji.spring_back_end.dto.CategorieDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Categorie;
import com.odji.spring_back_end.repository.CategorieRepository;
import com.odji.spring_back_end.services.CategorieService;
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
    public class CategorieController {

    private final CategorieRepository categorieRepository;
    private final CategorieService categorieService;

    // get all categorie
    @GetMapping("/categories/list")
    public List<CategorieDto> getAllCategories() {
        List<Categorie> categories = categorieRepository.findAll(); // Assuming you have a JPA repository named 'produitRepository'
        return categorieService.categoriesDtoList(categorieRepository.findAll()); // Convert products to DTOs
    }

    // create categories
    @PostMapping("categories")
    public ResponseEntity<CategorieDto> createCategorie(@RequestBody CategorieDto categorieDto) {
        Categorie categorie = categorieService.dtoToCategorie(categorieDto);
        Categorie savedCategorie = categorieRepository.save(categorie);
        return ResponseEntity.ok(categorieService.categorieToDto(savedCategorie));
    }

    //get categorie by id
    @GetMapping("categories/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Integer id) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);

        if (optionalCategorie.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalCategorie.get());
    }

    //
    // Update a category
    @PutMapping("categories/{id}")
    public ResponseEntity<CategorieDto> updateCategorie(@PathVariable Integer id, @RequestBody CategorieDto categorieDetailsDto) {
        categorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categorie not found with id: " + id));
        Categorie updateCategorie;

        updateCategorie = categorieService.dtoToCategorie(categorieDetailsDto);
        updateCategorie.setId(id);
        categorieDetailsDto = categorieService.categorieToDto(categorieRepository.save(updateCategorie));
        return ResponseEntity.ok(categorieDetailsDto);
    }

    // build delete inscription REST API
    @DeleteMapping("categories/{id}")
    public ResponseEntity<HttpStatus> deleteCategorie(@PathVariable Integer id) {

        Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("categorie  not exist with id: " + id));

        categorieRepository.delete(categorie);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}


