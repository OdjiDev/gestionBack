package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.SuivieDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Categorie;
import com.odji.spring_back_end.model.Personel;
import com.odji.spring_back_end.model.Suivie;
import com.odji.spring_back_end.repository.CategorieRepository;
import com.odji.spring_back_end.repository.PersonelRepository;
import com.odji.spring_back_end.repository.SuivieRepository;
import com.odji.spring_back_end.services.SuivieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class SuivieController {



        private final SuivieRepository suivieRepository;
        private  final SuivieService suivieService;
        private  final CategorieRepository categorieRepository;
        private  final PersonelRepository personelRepository;



        // build create suivie REST API
        @PostMapping("/suivies")
        public SuivieDto createSuivie(@RequestBody SuivieDto suivieDto) {
            Suivie suivie= suivieService.dtoToSuivie(suivieDto);
//

            Integer personelId= suivie.getPersonel().getId();
            Optional<Personel> existingPersonelOptional= personelRepository.findById(personelId);

            //Verification de l'existance de la personel
            if(existingPersonelOptional.isPresent()){
                // Si  la Personel est trouvé l'affecter  au produit
                suivie.setPersonel(existingPersonelOptional.get());
            }



//            Integer categorieId= suivieDto.getCategorieDto().getId();
//            Optional<Categorie> existingCategorieOptional= categorieRepository.findById(categorieId);
//
//            //Verification de l'existance de la categorie
//            if(existingCategorieOptional.isPresent()){
//                // Si  la categorie est trouvé l'affecter  au suivie
//                suivie.setCategorie(existingCategorieOptional.get());


            // enrégistrement du suivie dans la base de donnée
            suivieDto= suivieService.suivieToDto(suivieRepository.save(suivie));
            return suivieDto;
        }

//        @GetMapping("/suivies/sans-avarie")
//        public List<SuivieDto> getSuiviesSansAvarie() {
//            return suivieService.getSuiviesSansAvarie();
//        }


// build get all product

        @GetMapping("/suivies/list")
        // Replace placeholders with your actual logic for data access using DTOs
        public List<SuivieDto> getAllSuivies() {
            List<Suivie> suivies = suivieRepository.findAll(); // Assuming you have a JPA repository named 'suivieRepository'
            return suivieService.suivieDtoList(suivieRepository.findAll()); // Convert products to DTOs
        }
        //           // build get product by id REST API
        //get product by id
        @GetMapping("/suivies/{id}")
        public ResponseEntity<SuivieDto> getDSuivieById(@PathVariable  Integer id){
            Suivie suivie = suivieRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Suivie not exist with id:" + id));
            return ResponseEntity.ok(suivieService.suivieToDto(suivie));
        }

        // build update Suivie REST API
        @PutMapping("/suivies/{id}")
        public ResponseEntity<SuivieDto> updateSuivie(@PathVariable Integer id,@RequestBody SuivieDto suivieDetailsDto) {
            Suivie updateSuivie = suivieRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("suivie not exist with id: " + id));
            updateSuivie = suivieService.dtoToSuivie(suivieDetailsDto);
            updateSuivie.setId(id);

            suivieDetailsDto= suivieService.suivieToDto(suivieRepository.save(updateSuivie));

            return ResponseEntity.ok(suivieDetailsDto);
        }



        // build delete demande REST API
        @DeleteMapping("suivies/{id}")
        public ResponseEntity<HttpStatus> deleteSuivie(@PathVariable Integer id){
            Suivie suivie = suivieRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Suivie not exist with id: " + id));

            suivieRepository.delete(suivie);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

    }


