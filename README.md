# FashionApp

FashionApp is a full-stack fashion platform application that allows users to browse and manage models, brands, and outfits.  
This project was developed as part of a DevOps course using modern technologies including Spring Boot for the backend and React for the frontend.

## Technologies Used

- **Backend:** Spring Boot, Java, PostgreSQL  
- **Frontend:** React, JavaScript  
- **DevOps:** Docker, Docker Compose, Jenkins, Kubernetes (in progress)  

## Features

- Browse and manage brands, models, and outfits  
- REST API backend with full CRUD operations  
- Responsive React frontend with modular components  
- Dockerized application for easy deployment  
- Jenkins CI/CD pipeline automating build and deployment  
- PostgreSQL database with Docker volume persistence  

## Getting Started

### Clone the repository

```bash
git clone https://github.com/yourusername/fashionapp.git
cd fashionapp

## Run with Docker Compose
docker-compose up --build
This will start the backend, frontend, and PostgreSQL database as containers.
### Access the app
Frontend: http://localhost:3000
Backend API: http://localhost:8080/api

## Jenkins CI/CD
Jenkins is configured to listen for pushes on the main branch
On each push, Jenkins builds Docker images for backend and frontend
Docker images are pushed to DockerHub

