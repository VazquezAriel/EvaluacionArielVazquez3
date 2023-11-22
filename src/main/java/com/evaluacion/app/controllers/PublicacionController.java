package com.evaluacion.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.evaluacion.app.models.Publicacion;
import com.evaluacion.app.services.PublicacionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/posts")
public class PublicacionController {

    @Autowired
    private PublicacionService service;
    
    @GetMapping("/get-and-save-data")
    public String getAndSaveData() {
        return service.getAndSaveData();
    }

    @GetMapping("/get-all")
    @ResponseBody
    public List<Publicacion> listar() {
        List<Publicacion> publicaciones = service.getAll();
        return publicaciones;
    }

    @GetMapping("/search")
    public String searchPublicacion(@RequestParam(required = false) Integer id, @RequestParam(required = false) String title) {
        if (id != null) return service.searchById(id);
        if (title != null) return service.searchByTitle(title);
        return "Debes proporcionar al menos un ID o un título.";
    }
    
}
