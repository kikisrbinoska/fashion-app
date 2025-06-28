package org.example.fashionapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String height;
    private String bio;
    private String imageUrl;
    @Version
    private Integer version;

    public Model(Long id, String name, String height, String bio, String imageUrl) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.bio = bio;
        this.imageUrl = imageUrl;
    }

    public Model() {

    }
}
