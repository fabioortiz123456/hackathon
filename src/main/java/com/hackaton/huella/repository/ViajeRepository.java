/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.repository;

import com.hackaton.huella.crudRepository.ViajeCrudRepository;
import com.hackaton.huella.model.Viaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cjop1
 */
@Repository
public class ViajeRepository {

    @Autowired
    private ViajeCrudRepository viajeCrudRepository;

    /**
     * READ
     */
    public List<Viaje> getAll() {
        return (List<Viaje>) viajeCrudRepository.findAll();
    }

    /**
     * READ by Id
     */
    public Optional<Viaje> getViaje(int idViaje) {
        return viajeCrudRepository.findById(idViaje);
    }

    /**
     * CREATE AND UPDATE
     */
    public Viaje save(Viaje viaje) {
        return viajeCrudRepository.save(viaje);
    }

    /**
     * DELETE
     */
    public void delete(Viaje viaje) {
        viajeCrudRepository.delete(viaje);
    }
}
