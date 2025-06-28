import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

import BrandsPage from "./pages/BrandsPage";
import ModelsPage from "./pages/ModelsPage";
import OutfitsPage from "./pages/OutfitsPage";

function App() {
  return (
      <Router>
        <nav style={{ marginBottom: 20 }}>
          <Link to="/" style={{ marginRight: 10 }}>Brands</Link>
          <Link to="/models" style={{ marginRight: 10 }}>Models</Link>
          <Link to="/outfits">Outfits</Link>
        </nav>
        <Routes>
          <Route path="/" element={<BrandsPage />} />
          <Route path="/models" element={<ModelsPage />} />
          <Route path="/outfits" element={<OutfitsPage />} />
        </Routes>
      </Router>
  );
}

export default App;
