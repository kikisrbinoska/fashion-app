import React from "react";
import "./ModelCard.css";

export default function ModelCard({ model }) {
    return (
        <div className="model-card">
            <img src={model.imageUrl} alt={model.name} />
            <div className="model-info">
                <h3>{model.name}</h3>
                <p><strong>Height:</strong> {model.height}</p>
                <p>{model.bio}</p>
            </div>
        </div>
    );
}
