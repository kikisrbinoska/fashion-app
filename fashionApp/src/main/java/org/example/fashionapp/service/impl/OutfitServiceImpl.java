package org.example.fashionapp.service.impl;

import org.example.fashionapp.model.Outfit;
import org.example.fashionapp.repository.OutfitRepository;
import org.example.fashionapp.service.OutfitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutfitServiceImpl implements OutfitService {
    private final OutfitRepository outfitRepository;

    public OutfitServiceImpl(OutfitRepository outfitRepository) {
        this.outfitRepository = outfitRepository;
    }

    @Override
    public List<Outfit> findAll() {
        return outfitRepository.findAll();
    }

    @Override
    public Optional<Outfit> findById(Long id) {
        return outfitRepository.findById(id);
    }

    @Override
    public Optional<Outfit> update(Long id, Outfit outfit) {
        return outfitRepository.findById(id)
                .map(existingOutfit -> {
                    if (outfit.getName() != null) {
                        existingOutfit.setName(outfit.getName());
                    }
                    if (outfit.getDescription() != null) {
                        existingOutfit.setDescription(outfit.getDescription());
                    }
                    if (outfit.getId() != null) {
                        existingOutfit.setId(outfit.getId());
                    }
                    if (outfit.getCategory() != null) {
                        existingOutfit.setCategory(outfit.getCategory());
                    }
                    if (outfit.getSeason() != null) {
                        existingOutfit.setSeason(outfit.getSeason());
                    }
                    if (outfit.getBrandId() != null) {
                        existingOutfit.setBrandId(outfit.getBrandId());
                    }
                    if (outfit.getStyle() != null) {
                        existingOutfit.setStyle(outfit.getStyle());
                    }
                    if (outfit.getModelId() != null) {
                        existingOutfit.setModelId(outfit.getModelId());
                    }
                    if (outfit.getImageUrl() != null) {
                        existingOutfit.setImageUrl(outfit.getImageUrl());
                    }
                    Outfit updated = outfitRepository.save(existingOutfit);
                    return updated;
                });
    }

    @Override
    public Outfit save(Outfit outfit) {
        return outfitRepository.save(outfit);
    }

    @Override
    public void deleteById(Long id) {
        outfitRepository.deleteById(id);
    }
}
