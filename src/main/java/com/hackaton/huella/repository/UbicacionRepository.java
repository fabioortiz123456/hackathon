/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.repository;

import com.hackaton.huella.crudRepository.UbicacionCrudRepository;
import com.hackaton.huella.model.Ubicacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cjop1
 */
@Repository
public class UbicacionRepository {

    @Autowired
    private UbicacionCrudRepository ubicacionCrudRepository;

    /**
     * READ
     */
    public List<Ubicacion> getAll() {
        return (List<Ubicacion>) ubicacionCrudRepository.findAll();
    }

    /**
     * READ by Id
     */
    public Optional<Ubicacion> getUbicacion(int idUbicacion) {
        return ubicacionCrudRepository.findById(idUbicacion);
    }

    /**
     * CREATE AND UPDATE
     */
    public Ubicacion save(Ubicacion ubicacion) {
        return ubicacionCrudRepository.save(ubicacion);
    }

    /**
     * DELETE
     */
    public void delete(Ubicacion ubicacion) {
        ubicacionCrudRepository.delete(ubicacion);
    }
}
