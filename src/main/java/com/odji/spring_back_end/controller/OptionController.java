package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.CategorieDto;
import com.odji.spring_back_end.dto.OptionDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.Categorie;
import com.odji.spring_back_end.model.Option;
import com.odji.spring_back_end.repository.OptionRepository;
import com.odji.spring_back_end.repository.OptionRepository;
import com.odji.spring_back_end.services.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://odjidev.github.io/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OptionController {

    private final OptionRepository optionRepository;
    private final OptionService optionService;

    // get all option


// build get all product

    @GetMapping("/roles/list")
    // Replace placeholders with your actual logic for data access using DTOs
    public List<OptionDto> getAllOptions() {
        List<Option> options = optionRepository.findAll(); // Assuming you have a JPA repository named 'optionRepository'
        return optionService.optionDtoList(optionRepository.findAll()); // Convert products to DTOs
    }


    // create options
    @PostMapping("roles")
    public ResponseEntity<OptionDto> createOption(@RequestBody OptionDto optionDto) {
        Option option = optionService.dtoToOption(optionDto);
        Option savedOption = optionRepository.save(option);
        return ResponseEntity.ok(optionService.OptionToDto(savedOption));
    }

    //get option by id
    @GetMapping("roles/{id}")
    public ResponseEntity<Option> getOptionById(@PathVariable Integer id) {
        Optional<Option> optionalOption = optionRepository.findById(id);

        if (optionalOption.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalOption.get());
    }

    //
    // Update a category
    @PutMapping("roles/{id}")
    public ResponseEntity<OptionDto> updateOption(@PathVariable Integer id, @RequestBody OptionDto optionDetailsDto) {
        optionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Option not found with id: " + id));
        Option updateOption;

        updateOption = optionService.dtoToOption(optionDetailsDto);
        updateOption.setId(id);
        optionDetailsDto = optionService.OptionToDto(optionRepository.save(updateOption));
        ResponseEntity<OptionDto> ok = ResponseEntity.ok(optionDetailsDto);
        return ok;
    }

    // build delete inscription REST API
    @DeleteMapping("roles/{id}")
    public ResponseEntity<HttpStatus> deleteOption(@PathVariable Integer id) {

        Option option = optionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("option  not exist with id: " + id));

        optionRepository.delete(option);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
