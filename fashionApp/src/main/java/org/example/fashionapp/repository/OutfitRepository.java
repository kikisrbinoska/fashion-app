package org.example.fashionapp.repository;

import org.example.fashionapp.model.Outfit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutfitRepository extends JpaRepository<Outfit, Long> {
}
