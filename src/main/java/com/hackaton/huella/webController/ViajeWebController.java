/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.webController;

import com.hackaton.huella.model.Viaje;
import com.hackaton.huella.services.ViajeServices;
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
@RequestMapping("/api/Viaje")
@CrossOrigin(origins = "*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ViajeWebController {
    
    @Autowired
    private ViajeServices viajeServices;
    @GetMapping("/all")
    public List <Viaje> getViaje(){
        return viajeServices.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Viaje> getViaje(@PathVariable("id") int id) {
        return viajeServices.getViaje(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Viaje save(@RequestBody Viaje viaje) {
        return viajeServices.save(viaje);
    }
     
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Viaje update(@RequestBody Viaje viaje) {
        return viajeServices.update(viaje);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("id") int id) {
        return viajeServices.deleteViaje(id);
    }
    
    
}
