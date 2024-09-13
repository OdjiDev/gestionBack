package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.AvarieDto;
import com.odji.spring_back_end.dto.BureauDto;
import com.odji.spring_back_end.dto.BureauDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Avarie;
import com.odji.spring_back_end.model.Bureau;
import com.odji.spring_back_end.model.Bureau;
import com.odji.spring_back_end.repository.BureauRepository;
import com.odji.spring_back_end.services.BureauService;
import com.odji.spring_back_end.services.DemandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BureauController {
    // create bureau
    private  final BureauService bureauService;
    private final DemandeService demandeService;
    private  final BureauRepository bureauRepository;

    //Create Bureau
    @PostMapping("bureaus")
    public ResponseEntity<BureauDto> createBureau(@RequestBody BureauDto bureauDto) {
        Bureau bureau = bureauService.dtoToBureau(bureauDto);
       Bureau savedBureau= bureauRepository.save(bureau);
        return ResponseEntity.ok(bureauService.BureauToDto(savedBureau));
    }
    // get all bureau
    @GetMapping("/bureaus/list")
    public List<BureauDto> getAllBureau() {
        List<Bureau> bureaus = bureauRepository.findAll(); // Assuming you have a JPA repository named 'produitRepository'
        return bureauService.bureausDtoList(bureauRepository.findAll()); // Convert products to DTOs
    }


    //get bureau by id
    @GetMapping("bureaus/{id}")
    public ResponseEntity<Bureau> getBureauById(@PathVariable Integer id) {
        Optional<Bureau> optionalBureau = bureauRepository.findById(id);

        if (optionalBureau.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalBureau.get());
    }
    // Update a category
    @PutMapping("bureaus/{id}")
    public ResponseEntity<BureauDto> updateBureau(@PathVariable Integer id, @RequestBody BureauDto bureauDetailsDto) {
        bureauRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bureau not found with id: " + id));
        Bureau updateBureau;

        updateBureau = bureauService.dtoToBureau(bureauDetailsDto);
        updateBureau.setId(id);
        bureauDetailsDto=bureauService.BureauToDto(bureauRepository.save(updateBureau));
        return ResponseEntity.ok( bureauDetailsDto);
    }

    // build delete inscription REST API
    @DeleteMapping("bureaus/{id}")
    public ResponseEntity<HttpStatus> deleteBureau(@PathVariable Integer id){

        Bureau bureau = bureauRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("bureau  not exist with id: " + id));

        bureauRepository.delete(bureau);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
