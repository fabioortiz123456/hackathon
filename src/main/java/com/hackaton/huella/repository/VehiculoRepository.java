/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.repository;

import com.hackaton.huella.model.Vehiculo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hackaton.huella.crudRepository.VehiculoCrudRepository;

/**
 *
 * @author cjop1
 */
@Repository
public class VehiculoRepository {

    @Autowired
    private VehiculoCrudRepository vehiculoCrudRepository;

    /**
     * READ
     */
    public List<Vehiculo> getAll() {
        return (List<Vehiculo>) vehiculoCrudRepository.findAll();
    }

    /**
     * READ by Id
     */
    public Optional<Vehiculo> getVehiculo(int idVehiculo) {
        return vehiculoCrudRepository.findById(idVehiculo);
    }

    /**
     * CREATE AND UPDATE
     */
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoCrudRepository.save(vehiculo);
    }

    /**
     * DELETE
     */
    public void delete(Vehiculo vehiculo) {
        vehiculoCrudRepository.delete(vehiculo);
    }
}
