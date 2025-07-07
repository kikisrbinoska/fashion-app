package org.example.fashionapp.controller;

import org.example.fashionapp.model.Brand;
import org.example.fashionapp.model.Model;
import org.example.fashionapp.service.ModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }
    @GetMapping
    public List<Model> findAll() {
        return modelService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Model> findById(@PathVariable Long id) {
        return modelService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Model> save(@RequestBody Model createModel) {
        createModel.setId(null);
        Model savedModel = modelService.save(createModel);
        return ResponseEntity.ok(savedModel);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Model> update(
            @PathVariable Long id,
            @RequestBody Model model
    ) {
        return modelService.update(id, model)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (modelService.findById(id).isPresent()) {
            modelService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
