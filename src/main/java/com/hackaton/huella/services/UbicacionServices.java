/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.services;

import com.hackaton.huella.model.Ubicacion;
import com.hackaton.huella.repository.UbicacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cjop1
 */
@Service
public class UbicacionServices {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public List<Ubicacion> getAll() {
        return ubicacionRepository.getAll();
    }

    public Optional<Ubicacion> getUbicacion(int idUbicacion) {
        return ubicacionRepository.getUbicacion(idUbicacion);
    }

    public Ubicacion save(Ubicacion ubicacion) {
        if (ubicacion.getIdUbicacion() == null) {
            return ubicacionRepository.save(ubicacion);
        } else {
            Optional<Ubicacion> evt = ubicacionRepository.getUbicacion(ubicacion.getIdUbicacion());
            if (evt.isEmpty()) {
                return ubicacionRepository.save(ubicacion);
            } else {
                return ubicacion;
            }

        }

    }

    public Ubicacion update(Ubicacion ubicacion) {
        if (ubicacion.getIdUbicacion() != null) {
            Optional<Ubicacion> evt = ubicacionRepository.getUbicacion(ubicacion.getIdUbicacion());
            if (!evt.isEmpty()) {
                if (ubicacion.getDireccion() != null) {
                    evt.get().setDireccion(ubicacion.getDireccion());
                }
                if (ubicacion.getUsuario() != null) {
                    evt.get().setUsuario(ubicacion.getUsuario());
                }
                if (ubicacion.getPais() != null) {
                    evt.get().setPais(ubicacion.getPais());
                }
                if (ubicacion.getCiudad() != null) {
                    evt.get().setCiudad(ubicacion.getCiudad());
                }
                if (ubicacion.getDireccion() != null) {
                    evt.get().setDireccion(ubicacion.getDireccion());
                }
                ubicacionRepository.save(evt.get());
                return evt.get();
            } else {
                return ubicacion;
            }
        } else {
            return ubicacion;
        }
    }

    public boolean deleteUbicacion(int IdUbicacion) {
        Boolean aBoolean = getUbicacion(IdUbicacion).map(ubicacion -> {
            ubicacionRepository.delete(ubicacion);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
