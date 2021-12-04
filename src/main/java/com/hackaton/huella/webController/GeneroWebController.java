/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.webController;

import com.hackaton.huella.model.Genero;
import com.hackaton.huella.services.GeneroServices;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cjop1
 */
@RestController
@RequestMapping("/api/Genero")
@CrossOrigin(origins = "*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GeneroWebController {
    
    @Autowired
    private GeneroServices usuarioServices;
    @GetMapping("/all")
    public List <Genero> getGenero(){
        return usuarioServices.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Genero> getGenero(@PathVariable("id") int id) {
        return usuarioServices.getGenero(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Genero save(@RequestBody Genero genero) {
        return usuarioServices.save(genero);
    }
     
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Genero update(@RequestBody Genero genero) {
        return usuarioServices.update(genero);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("id") int id) {
        return usuarioServices.deleteGenero(id);
    }
    
    
}
