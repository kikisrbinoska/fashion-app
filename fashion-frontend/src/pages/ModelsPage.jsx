import React, { useEffect, useState } from "react";
import ModelCard from "../components/ModelCard";

export default function ModelsPage() {
    const [models, setModels] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetch("http://localhost:8080/api/models")
            .then((res) => res.json())
            .then((data) => {
                setModels(data);
                setLoading(false);
            })
            .catch(() => setLoading(false));
    }, []);

    if (loading) return <div>Loading models...</div>;
    if (!models || models.length === 0) return <div>No models found</div>;

    return (
        <div>
            <h2>Models</h2>
            {models.map((model) => (
                <ModelCard key={model.id} model={model} />
            ))}
        </div>
    );
}
