/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.webController;

import com.hackaton.huella.model.Vehiculo;
import com.hackaton.huella.services.VehiculoServices;
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
@RequestMapping("/api/Vehiculo")
@CrossOrigin(origins = "*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class VehiculoWebController {
    
    @Autowired
    private VehiculoServices vehiculoServices;
    @GetMapping("/all") 
    public List <Vehiculo> getVehiculo(){
        return vehiculoServices.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Vehiculo> getVehiculo(@PathVariable("id") int id) {
        return vehiculoServices.getVehiculo(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Vehiculo save(@RequestBody Vehiculo vehiculo) {
        return vehiculoServices.save(vehiculo);
    }
     
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Vehiculo update(@RequestBody Vehiculo vehiculo) {
        return vehiculoServices.update(vehiculo);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("id") int id) {
        return vehiculoServices.deleteVehiculo(id);
    }
    
    
}
