package org.example.fashionapp.config;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.fashionapp.model.Brand;
import org.example.fashionapp.model.Model;
import org.example.fashionapp.model.Outfit;
import org.example.fashionapp.repository.BrandRepository;
import org.example.fashionapp.repository.ModelRepository;
import org.example.fashionapp.repository.OutfitRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final OutfitRepository outfitRepository;

    @PostConstruct
    public void initData() {
        if (brandRepository.count() == 0 && modelRepository.count() == 0 && outfitRepository.count() == 0) {

            // BRANDS
            var ysl = brandRepository.save(new Brand(null, "Saint Laurent",
                    "https://upload.wikimedia.org/wikipedia/commons/4/43/Yves_Saint_Laurent_Logo.svg",
                    "Luxury French fashion house founded by Yves Saint Laurent.",
                    "France"));

            var prada = brandRepository.save(new Brand(null, "Prada",
                    "https://upload.wikimedia.org/wikipedia/commons/3/3e/Prada-Logo.svg",
                    "Italian luxury fashion house known for leather handbags and accessories.",
                    "Italy"));

            var gucci = brandRepository.save(new Brand(null, "Gucci",
                    "https://upload.wikimedia.org/wikipedia/commons/4/4e/Gucci_Logo.svg",
                    "Iconic Italian brand known for bold styles and high-end fashion.",
                    "Italy"));

            var chiara = brandRepository.save(new Brand(null, "Chiara Ferragni",
                    "https://upload.wikimedia.org/wikipedia/commons/a/a2/Chiara_Ferragni_Logo.svg",
                    "Fashion brand by influencer Chiara Ferragni featuring playful, modern styles.",
                    "Italy"));

            // MODELS
            var bella = modelRepository.save(new Model(null, "Bella Hadid", "1.75m",
                    "International supermodel known for runway and editorial work.",
                    "https://upload.wikimedia.org/wikipedia/commons/1/1d/Bella_Hadid_2019.jpg"));

            var kendall = modelRepository.save(new Model(null, "Kendall Jenner", "1.79m",
                    "American fashion model and television personality.",
                    "https://upload.wikimedia.org/wikipedia/commons/0/0c/Kendall_Jenner_2018.jpg"));

            var chiaraModel = modelRepository.save(new Model(null, "Chiara Ferragni", "1.77m",
                    "Italian entrepreneur, fashion blogger and model.",
                    "https://upload.wikimedia.org/wikipedia/commons/4/41/Chiara_Ferragni_-_2019.jpg"));

            // OUTFITS
            outfitRepository.save(new Outfit(null, "Spring Chic", "Elegant light trench and boots.",
                    "Spring", "Casual", "Outerwear",
                    "https://cdn-images.farfetch-contents.com/17/40/84/90/17408490_37308889_1000.jpg",
                    ysl.getId(), bella.getId()));

            outfitRepository.save(new Outfit(null, "Summer Vibes", "Crop top with designer shorts.",
                    "Summer", "Street", "Casual",
                    "https://cdn-images.farfetch-contents.com/16/35/02/22/16350222_30240489_1000.jpg",
                    prada.getId(), kendall.getId()));

            outfitRepository.save(new Outfit(null, "Winter Glam", "Fur coat with leather boots.",
                    "Winter", "Glam", "Coat",
                    "https://cdn-images.farfetch-contents.com/17/34/52/45/17345245_36815289_1000.jpg",
                    gucci.getId(), bella.getId()));

            outfitRepository.save(new Outfit(null, "Chiara Signature", "Sparkling pink outfit with eye motif.",
                    "All", "Trendy", "Party",
                    "https://cdn-images.farfetch-contents.com/15/68/26/52/15682652_28920754_1000.jpg",
                    chiara.getId(), chiaraModel.getId()));
        }
    }
}
