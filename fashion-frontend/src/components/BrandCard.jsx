import React from "react";

export default function BrandCard({ brand }) {
    return (
        <div style={{ border: "1px solid #ccc", padding: 10, marginBottom: 10 }}>
            <img src={brand.logoUrl} alt={brand.name} width={80} />
            <h3>{brand.name}</h3>
            <p><i>{brand.country}</i></p>
            <p>{brand.description}</p>
        </div>
    );
}
