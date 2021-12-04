/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.services;

import com.hackaton.huella.model.Vehiculo;
import com.hackaton.huella.repository.VehiculoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cjop1
 */
@Service
public class VehiculoServices {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> getAll() {
        return vehiculoRepository.getAll();
    }

    public Optional<Vehiculo> getVehiculo(int idVehiculo) {
        return vehiculoRepository.getVehiculo(idVehiculo);
    }

    public Vehiculo save(Vehiculo vehiculo) {
        if (vehiculo.getIdVehiculo() == null) {
            return vehiculoRepository.save(vehiculo);
        } else {
            Optional<Vehiculo> evt = vehiculoRepository.getVehiculo(vehiculo.getIdVehiculo());
            if (evt.isEmpty()) {
                return vehiculoRepository.save(vehiculo);
            } else {
                return vehiculo;
            }

        }

    }

    public Vehiculo update(Vehiculo vehiculo) {
        if (vehiculo.getIdVehiculo() != null) {
            Optional<Vehiculo> evt = vehiculoRepository.getVehiculo(vehiculo.getIdVehiculo());
            if (!evt.isEmpty()) {
                if (vehiculo.getVehiculo() != null) {
                    evt.get().setVehiculo(vehiculo.getVehiculo());
                }
                if (vehiculo.getCaractVehiculo() != null) {
                    evt.get().setCaractVehiculo(vehiculo.getCaractVehiculo());
                }
                if (vehiculo.getHuellaCarbono() != 0) {
                    evt.get().setHuellaCarbono(vehiculo.getHuellaCarbono());
                }
                vehiculoRepository.save(evt.get());
                return evt.get();
            } else {
                return vehiculo;
            }
        } else {
            return vehiculo;
        }
    }

    public boolean deleteVehiculo(int IdVehiculo) {
        Boolean aBoolean = getVehiculo(IdVehiculo).map(vehiculo -> {
            vehiculoRepository.delete(vehiculo);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
