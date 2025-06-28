package org.example.fashionapp.repository;

import org.example.fashionapp.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
