import React from "react";

export default function OutfitCard({ outfit }) {
    return (
        <div style={{ border: "1px solid #ccc", padding: 10, marginBottom: 10 }}>
            <img src={outfit.imageUrl} alt={outfit.name} width={80} />
            <h3>{outfit.name}</h3>
            <p>{outfit.description}</p>
            <p>Season: {outfit.season}</p>
            <p>Style: {outfit.style}</p>
            <p>Category: {outfit.category}</p>
        </div>
    );
}
