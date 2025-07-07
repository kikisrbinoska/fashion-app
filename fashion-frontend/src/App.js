import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import NavBar from "./components/NavBar";
import BrandsPage from "./pages/BrandsPage";
import ModelsPage from "./pages/ModelsPage";
import OutfitsPage from "./pages/OutfitsPage";

function App() {
    return (
        <Router>
            <NavBar />
            <div style={{ padding: "20px", maxWidth: "900px", margin: "auto" }}>
                <Routes>
                    <Route path="/" element={<BrandsPage />} />
                    <Route path="/models" element={<ModelsPage />} />
                    <Route path="/outfits" element={<OutfitsPage />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;
