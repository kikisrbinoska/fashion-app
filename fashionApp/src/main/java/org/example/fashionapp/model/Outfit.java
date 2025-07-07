package org.example.fashionapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Outfit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String season;
    private String style;
    private String category;
    private String imageUrl;

    private Long brandId;
    private Long modelId;
    @Version
    private Integer version;

    public Outfit(Long id, String name, String description, String season, String style, String category, String imageUrl, Long brandId, Long modelId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.season = season;
        this.style = style;
        this.category = category;
        this.imageUrl = imageUrl;
        this.brandId = brandId;
        this.modelId = modelId;
    }

    public Outfit() {

    }
}
