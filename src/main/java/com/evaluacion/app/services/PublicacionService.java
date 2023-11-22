package com.evaluacion.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.evaluacion.app.models.Publicacion;
import com.evaluacion.app.repositories.PublicacionRepository;

@Component
public class PublicacionService {

    @Autowired
    private PublicacionRepository repository;
    
    private static final String EXTERNAL_API_URL = "https://jsonplaceholder.typicode.com/posts";

    public List<Publicacion> getAll() {
        return repository.findAll();
    }

    public String getAndSaveData() {

        try {
            RestTemplate restTemplate = new RestTemplate();
            Publicacion[] publicaciones = restTemplate.getForObject(EXTERNAL_API_URL, Publicacion[].class);
    
            for (Publicacion publicacion : publicaciones) {
                repository.save(publicacion);
            }

        } catch (Exception e) {
            return "La Data no se guardo" + "Error: " + e.getMessage();
        }

        return "Data guardada exitosamente";
    }
    
}
