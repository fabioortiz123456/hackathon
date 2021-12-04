/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.services;

import com.hackaton.huella.model.Viaje;
import com.hackaton.huella.repository.ViajeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cjop1
 */
@Service
public class ViajeServices {

    @Autowired
    private ViajeRepository viajeRepository;

    public List<Viaje> getAll() {
        return viajeRepository.getAll();
    }

    public Optional<Viaje> getViaje(int idViaje) {
        return viajeRepository.getViaje(idViaje);
    }

    public Viaje save(Viaje viaje) {
        if (viaje.getIdViaje() == null) {
            return viajeRepository.save(viaje);
        } else {
            Optional<Viaje> evt = viajeRepository.getViaje(viaje.getIdViaje());
            if (evt.isEmpty()) {
                return viajeRepository.save(viaje);
            } else {
                return viaje;
            }

        }

    }

    public Viaje update(Viaje viaje) {
        if (viaje.getIdViaje() != null) {
            Optional<Viaje> evt = viajeRepository.getViaje(viaje.getIdViaje());
            if (!evt.isEmpty()) {
                if (viaje.getVehiculo() != null) {
                    evt.get().setVehiculo(viaje.getVehiculo());
                }
                if (viaje.getFechaViaje() != null) {
                    evt.get().setFechaViaje(viaje.getFechaViaje());
                }
                if (viaje.getDistancia()!= 0) {
                    evt.get().setDistancia(viaje.getDistancia());
                }
                
                viajeRepository.save(evt.get());
                return evt.get();
            } else {
                return viaje;
            }
        } else {
            return viaje;
        }
    }

    public boolean deleteViaje(int IdViaje) {
        Boolean aBoolean = getViaje(IdViaje).map(viaje -> {
            viajeRepository.delete(viaje);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
