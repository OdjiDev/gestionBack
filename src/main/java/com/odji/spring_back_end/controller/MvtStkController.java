package com.odji.spring_back_end.controller;

import com.odji.spring_back_end.dto.MvtStkDto;
import com.odji.spring_back_end.exeption.ResourceNotFoundException;
import com.odji.spring_back_end.model.MvtStk;
import com.odji.spring_back_end.model.Produit;
import com.odji.spring_back_end.repository.MvtStkRepository;
import com.odji.spring_back_end.repository.ProduitRepository;
import com.odji.spring_back_end.services.MvtStkService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MvtStkController {


    private final MvtStkService mvtStkService;
    private final MvtStkRepository mvtStkRepository;
    private  final ProduitRepository produitRepository;
    @PostMapping("mvtstks")
    public ResponseEntity<?> ajouterMouvementDeStock(@RequestBody MvtStkDto mvtStkDto) {
        try {
            // Vérifier si le produit existe
            Optional<Produit> produitOptional = produitRepository.findById(mvtStkDto.getProduitDto().getId());

            if (!produitOptional.isPresent()) {
                throw new ResourceNotFoundException("Le mouvement de stock doit être associé à un produit existant.");
            }

            Produit produit = produitOptional.get();

            // Créer un objet MvtStk et associer le produit
            MvtStk mvtStk = new MvtStk();
            mvtStk.setProduit(produit);
            mvtStk.setPrixAchat(mvtStkDto.getPrixAchat());
            mvtStk.setQuantite(mvtStkDto.getQuantite());
            mvtStk.setDate(mvtStkDto.getDate());

            // Sauvegarder le mouvement de stock
            mvtStkService.ajouterMouvementDeStock(mvtStk);

            return ResponseEntity.ok("Mouvement de stock ajouté.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



    @PostMapping("mvtstks/reduire")
    public ResponseEntity<?> reduireMouvementDeStock(@RequestBody MvtStkDto mvtStkDto) {
        try {
            // Vérifier si le produit existe
            Optional<Produit> produitOptional = produitRepository.findById(mvtStkDto.getProduitDto().getId());

            if (!produitOptional.isPresent()) {
                throw new ResourceNotFoundException("Le mouvement de stock doit être associé à un produit existant.");
            }

            Produit produit = produitOptional.get();

            // Créer un objet MvtStk et associer le produit
            MvtStk mvtStk = new MvtStk();
            mvtStk.setProduit(produit);
            mvtStk.setPrixAchat(mvtStkDto.getPrixAchat());
            mvtStk.setQuantite(mvtStkDto.getQuantite());
            mvtStk.setDate(mvtStkDto.getDate());

            // Sauvegarder le mouvement de stock
            mvtStkService.reduireMouvementDeStock(mvtStk);

            return ResponseEntity.ok("Mouvement de stock ajouté.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



//    @PostMapping("mvtstks")
////    @PostMapping("mvtstks/ajouter")
//        public ResponseEntity<MvtStk> ajouterMouvement(@RequestBody MvtStk mvtStkDto) {
//        MvtStk nouveauMvtStk = mvtStkService.ajouterMouvementDeStock(mvtStkDto);
//        return ResponseEntity.ok(nouveauMvtStk);
//    }

    // get all mvtStk
    @GetMapping("/mvtstks/list")
    public List<MvtStkDto> getAllMvtStks() {
        List<MvtStk> mvtStks = mvtStkRepository.findAll(); // Assuming you have a JPA repository named 'produitRepository'
        return mvtStkService.mvtStkDtoList(mvtStkRepository.findAll()); // Convert products to DTOs
    }


    // create mvtStks
//    @PostMapping("mvtstks")
//    public ResponseEntity<MvtStkDto> createMvtStk(@RequestBody MvtStkDto mvtStkDto) {
//        MvtStk mvtStk = mvtStkService.dtoToMvtStk(mvtStkDto);
//        MvtStk savedMvtStk = mvtStkRepository.save(mvtStk);
//
//        return ResponseEntity.ok(mvtStkService.mvtStkToDto(savedMvtStk));
    //}
    //get mvtStk by id
    @GetMapping("mvtstks/{id}")
    public ResponseEntity<MvtStk> getMvtStkById(@PathVariable Integer id) {
        Optional<MvtStk> optionalMvtStk = mvtStkRepository.findById(id);

        if (optionalMvtStk.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalMvtStk.get());
    }
    //
    // Update a category
    @PutMapping("mvtstks/{id}")
    public ResponseEntity<MvtStkDto> updateMvtStk(@PathVariable Integer id, @RequestBody MvtStkDto mvtStkDetailsDto) {
        mvtStkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MvtStk not found with id: " + id));
        MvtStk updateMvtStk;

        updateMvtStk = mvtStkService.dtoToMvtStk(mvtStkDetailsDto);
        updateMvtStk.setId(id);
        mvtStkDetailsDto=mvtStkService.mvtStkToDto(mvtStkRepository.save(updateMvtStk));
        return ResponseEntity.ok( mvtStkDetailsDto);
    }

    // build delete inscription REST API
    @DeleteMapping("mvtstks/{id}")
    public ResponseEntity<HttpStatus> deleteMvtStk(@PathVariable Integer id){

        MvtStk mvtStk = mvtStkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("mvtStk  not exist with id: " + id));

        mvtStkRepository.delete(mvtStk);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
