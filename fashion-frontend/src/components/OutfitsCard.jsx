import React from "react";
import "./OutfitCard.css";

export default function OutfitCard({ outfit }) {
    return (
        <div className="outfit-card">
            <img src={outfit.imageUrl} alt={outfit.name} />
            <div className="outfit-info">
                <h3>{outfit.name}</h3>
                <p>{outfit.description}</p>
                <p><strong>Season:</strong> {outfit.season}</p>
                <p><strong>Style:</strong> {outfit.style}</p>
                <p><strong>Category:</strong> {outfit.category}</p>
            </div>
        </div>
    );
}
