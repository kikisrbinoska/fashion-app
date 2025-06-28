import React, { useEffect, useState } from "react";
import BrandCard from "../components/BrandCard";

export default function BrandsPage() {
    const [brands, setBrands] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetch("http://localhost:8080/api/brands")
            .then(res => res.json())
            .then(data => {
                setBrands(data); // direktno postavi niza
                setLoading(false);
            })
            .catch(() => setLoading(false));
    }, []);

    if (loading) return <div>Loading brands...</div>;
    if (!brands || brands.length === 0) return <div>No brands found</div>;

    return (
        <div>
            <h2>Brands</h2>
            {brands.map(brand => (
                <BrandCard key={brand.id} brand={brand} />
            ))}
        </div>
    );
}
