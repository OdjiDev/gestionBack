package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.ContratDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Contrat;
import com.odji.spring_back_end.repository.ContratRepository;
import com.odji.spring_back_end.services.ContratService;
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
public class ContratController {

  
        private final ContratRepository contratRepository;
        private final ContratService contratService;

        // get all contrat
        @GetMapping("/contrats/list")
        public List<ContratDto> getAllContrats() {
            List<Contrat> contrats = contratRepository.findAll(); // Assuming you have a JPA repository named 'produitRepository'
            return contratService.contratDtoList(contratRepository.findAll()); // Convert products to DTOs
        }

        // create contrats
        @PostMapping("contrats")
        public ResponseEntity<ContratDto> createContrat(@RequestBody ContratDto contratDto) {
            Contrat contrat = contratService.dtoToContrat(contratDto);
            Contrat savedContrat = contratRepository.save(contrat);
            return ResponseEntity.ok(contratService.contratToDto(savedContrat));
        }



        //get contrat by id
        @GetMapping("/contrats/{id}")
        public ResponseEntity<Contrat> getContratById(@PathVariable Integer id) {
            Optional<Contrat> optionalContrat = contratRepository.findById(id);

            if (optionalContrat.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(optionalContrat.get());
        }

        //
        // Update a category
        @PutMapping("/contrats/{id}")
        public ResponseEntity<ContratDto> updateContrat(@PathVariable Integer id, @RequestBody ContratDto contratDetailsDto) {
            contratRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Contrat not found with id: " + id));
            Contrat updateContrat;

            updateContrat = contratService.dtoToContrat(contratDetailsDto);
            updateContrat.setId(id);
            contratDetailsDto = contratService.contratToDto(contratRepository.save(updateContrat));
            return ResponseEntity.ok(contratDetailsDto);
        }

        // build delete inscription REST API
        @DeleteMapping("/contrats/{id}")
        public ResponseEntity<HttpStatus> deleteContrat(@PathVariable Integer id) {

            Contrat contrat = contratRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("contrat  not exist with id: " + id));

            contratRepository.delete(contrat);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }

    }
