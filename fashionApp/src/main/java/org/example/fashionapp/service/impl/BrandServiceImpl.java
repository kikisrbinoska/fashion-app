package org.example.fashionapp.service.impl;

import org.example.fashionapp.model.Brand;
import org.example.fashionapp.repository.BrandRepository;
import org.example.fashionapp.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    @Override
    public Optional<Brand> update(Long id, Brand brand) {
        return brandRepository.findById(id)
                .map(existingBrand -> {
                    if (brand.getName() != null){
                        existingBrand.setName(brand.getName());
                    }
                    if (brand.getDescription() != null){
                        existingBrand.setDescription(brand.getDescription());
                    }
                    if (brand.getCountry() != null){
                        existingBrand.setCountry(brand.getCountry());
                    }
                    if (brand.getLogoUrl() != null){
                        existingBrand.setLogoUrl(brand.getLogoUrl());
                    }
                    if (brand.getVersion() != null) {
                        existingBrand.setVersion(brand.getVersion()); // 🔥 најважното
                    }
                    Brand updatedBrand = brandRepository.save(existingBrand);
                    return updatedBrand;
                });
    }

    @Override
    public Brand save(Brand brand) {
        return  brandRepository.save(brand);
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }
}
