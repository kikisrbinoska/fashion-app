import React from "react";
import "./BrandCard.css";

export default function BrandCard({ brand }) {
    return (
        <div className="brand-card">
            <img src={brand.logoUrl} alt={brand.name} />
            <div className="brand-info">
                <h3>{brand.name}</h3>
                <p><i>{brand.country}</i></p>
                <p>{brand.description}</p>
            </div>
        </div>
    );
}
