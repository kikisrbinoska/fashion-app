import React, { useEffect, useState } from "react";
import OutfitCard from "../components/OutfitsCard";

export default function OutfitsPage() {
    const [outfits, setOutfits] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetch("http://localhost:8080/api/outfits")
            .then((res) => res.json())
            .then((data) => {
                setOutfits(data); // direktno array od backend
                setLoading(false);
            })
            .catch(() => setLoading(false));
    }, []);

    if (loading) return <div>Loading outfits...</div>;
    if (!outfits || outfits.length === 0) return <div>No outfits found</div>;

    return (
        <div>
            <h2>Outfits</h2>
            {outfits.map((outfit) => (
                <OutfitCard key={outfit.id} outfit={outfit} />
            ))}
        </div>
    );
}
