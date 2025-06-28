package org.example.fashionapp.controller;

import org.example.fashionapp.model.Model;
import org.example.fashionapp.model.Outfit;
import org.example.fashionapp.service.OutfitService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/outfits")
public class OutfitController {
    private final OutfitService outfitService;

    public OutfitController(OutfitService outfitService) {
        this.outfitService = outfitService;
    }
    @GetMapping
    public List<Outfit> findAll() {
        return outfitService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Outfit> findById(@PathVariable Long id) {
        return outfitService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Outfit> save(@RequestBody Outfit createOutfit) {
        createOutfit.setId(null);
        Outfit savedOutfit = outfitService.save(createOutfit);
        return ResponseEntity.ok(savedOutfit);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Outfit> update(
            @PathVariable Long id,
            @RequestBody Outfit model
    ) {
        return outfitService.update(id, model)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (outfitService.findById(id).isPresent()) {
            outfitService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
