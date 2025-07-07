package org.example.fashionapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String logoUrl;
    private String description;
    private String country;
    @Version
    private Integer version;


    public Brand(Long id, String name, String logoUrl, String description, String country) {
        this.id = id;
        this.name = name;
        this.logoUrl = logoUrl;
        this.description = description;
        this.country = country;
    }

    public Brand() {

    }
}
