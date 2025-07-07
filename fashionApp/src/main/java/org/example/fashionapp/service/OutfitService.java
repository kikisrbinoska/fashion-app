package org.example.fashionapp.service;

import org.example.fashionapp.model.Model;
import org.example.fashionapp.model.Outfit;

import java.util.List;
import java.util.Optional;

public interface OutfitService {
    List<Outfit> findAll();

    Optional<Outfit> findById(Long id);

    Optional<Outfit> update(Long id, Outfit outfit);

    Outfit save(Outfit outfit);

    void deleteById(Long id);
}
