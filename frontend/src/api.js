import axios from "axios";

// Configuration de base pour les appels API
const backendAPI = axios.create({
    baseURL: import.meta.env.VITE_BACKEND_URL, // Récupérer l'URL depuis .env
});

export default backendAPI;
