package org.example.fashionapp.service;

import org.example.fashionapp.model.Brand;
import org.example.fashionapp.model.Model;
import org.example.fashionapp.model.Outfit;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    List<Brand> findAll();

    Optional<Brand> findById(Long id);

    Optional<Brand> update(Long id, Brand brand);

    Brand save(Brand brand);

    void deleteById(Long id);
}
