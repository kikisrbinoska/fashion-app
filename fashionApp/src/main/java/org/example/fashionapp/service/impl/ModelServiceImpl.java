package org.example.fashionapp.service.impl;

import org.example.fashionapp.model.Model;
import org.example.fashionapp.repository.ModelRepository;
import org.example.fashionapp.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    @Override
    public Optional<Model> findById(Long id) {
        return modelRepository.findById(id);
    }

    @Override
    public Optional<Model> update(Long id, Model model) {
        return modelRepository.findById(id)
                .map(existingModel -> {
                    if (model.getName() != null) {
                        existingModel.setName(model.getName());
                    }
                    if (model.getBio() != null) {
                        existingModel.setBio(model.getBio());
                    }
                    if (model.getId() != null) {
                        existingModel.setId(model.getId());
                    }
                    if (model.getHeight() != null) {
                        existingModel.setHeight(model.getHeight());
                    }
                    if (model.getImageUrl() != null) {
                        existingModel.setImageUrl(model.getImageUrl());
                    }
                    Model updatedModel = modelRepository.save(existingModel);
                    return updatedModel;
                });
    }

    @Override
    public Model save(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public void deleteById(Long id) {
        modelRepository.deleteById(id);
    }
}
