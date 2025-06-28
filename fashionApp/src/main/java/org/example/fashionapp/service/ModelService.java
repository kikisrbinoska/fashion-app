package org.example.fashionapp.service;

import org.example.fashionapp.model.Model;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    List<Model> findAll();

    Optional<Model> findById(Long id);

    Optional<Model> update(Long id, Model model);

    Model save(Model model);

    void deleteById(Long id);
}
