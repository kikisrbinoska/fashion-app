import React from "react";

export default function ModelCard({ model }) {
    return (
        <div style={{ border: "1px solid #ccc", padding: 10, marginBottom: 10 }}>
            <img src={model.imageUrl} alt={model.name} width={80} />
            <h3>{model.name}</h3>
            <p>Height: {model.height}</p>
            <p>{model.bio}</p>
        </div>
    );
}
