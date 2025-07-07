import React from "react";
import { NavLink } from "react-router-dom";
import "./NavBar.css";

export default function NavBar() {
    return (
        <nav className="navbar">
            <NavLink to="/" className={({ isActive }) => isActive ? "active-link" : ""}>Brands</NavLink>
            <NavLink to="/models" className={({ isActive }) => isActive ? "active-link" : ""}>Models</NavLink>
            <NavLink to="/outfits" className={({ isActive }) => isActive ? "active-link" : ""}>Outfits</NavLink>
        </nav>
    );
}
