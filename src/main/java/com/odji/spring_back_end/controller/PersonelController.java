package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.PersonelDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Personel;
import com.odji.spring_back_end.repository.PersonelRepository;
import com.odji.spring_back_end.services.PersonelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PersonelController {


    private final PersonelService personelService;
    private final PersonelRepository personelRepository;

    // get all personel
    @GetMapping("/personels/list")
    public List<PersonelDto> getAllPersonels() {
        List<Personel> personels = personelRepository.findAll(); // Assuming you have a JPA repository named 'produitRepository'
        return personelService.personelDtoList(personelRepository.findAll()); // Convert products to DTOs
    }

        // create personels
        @PostMapping("personels")
        public ResponseEntity<PersonelDto> createPersonel(@RequestBody PersonelDto personelDto) {
            Personel personel = personelService.dtoToPersonel(personelDto);
            Personel savedPersonel = personelRepository.save(personel);
            return ResponseEntity.ok(personelService.personelToDto(savedPersonel));
        }
        //get personel by id
        @GetMapping("personels/{id}")
        public ResponseEntity<Personel> getPersonelById(@PathVariable Integer id) {
            Optional<Personel> optionalPersonel = personelRepository.findById(id);

            if (optionalPersonel.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(optionalPersonel.get());
        }
        //
        // Update a category
        @PutMapping("personels/{id}")
        public ResponseEntity<PersonelDto> updatePersonel(@PathVariable Integer id, @RequestBody PersonelDto personelDetailsDto) {
            personelRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Personel not found with id: " + id));
            Personel updatePersonel;

            updatePersonel = personelService.dtoToPersonel(personelDetailsDto);
            updatePersonel.setId(id);
            personelDetailsDto=personelService.personelToDto(personelRepository.save(updatePersonel));
            return ResponseEntity.ok( personelDetailsDto);
        }

        // build delete inscription REST API
        @DeleteMapping("personels/{id}")
        public ResponseEntity<HttpStatus> deletePersonel(@PathVariable Integer id){

            Personel personel = personelRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("personel  not exist with id: " + id));

            personelRepository.delete(personel);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
}
