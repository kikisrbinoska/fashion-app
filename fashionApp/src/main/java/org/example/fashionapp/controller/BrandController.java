package org.example.fashionapp.controller;

import org.example.fashionapp.model.Brand;
import org.example.fashionapp.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> findAll() {
        return brandService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Brand> findById(@PathVariable Long id) {
        return brandService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public ResponseEntity<Brand> save(@RequestBody Brand createBrand) {
        createBrand.setId(null);
        Brand savedBrand = brandService.save(createBrand);
        return ResponseEntity.ok(savedBrand);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Brand> update(@PathVariable Long id, @RequestBody Brand brand) {
        brand.setId(id);
        return brandService.update(id, brand)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (brandService.findById(id).isPresent()) {
            brandService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
