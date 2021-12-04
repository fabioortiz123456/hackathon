/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.services;

import com.hackaton.huella.model.Genero;
import com.hackaton.huella.repository.GeneroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cjop1
 */
@Service
public class GeneroServices {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> getAll() {
        return generoRepository.getAll();
    }

    public Optional<Genero> getGenero(int idGenero) {
        return generoRepository.getGenero(idGenero);
    }

    public Genero save(Genero genero) {
        if (genero.getIdGenero() == null) {
            return generoRepository.save(genero);
        } else {
            Optional<Genero> evt = generoRepository.getGenero(genero.getIdGenero());
            if (evt.isEmpty()) {
                return generoRepository.save(genero);
            } else {
                return genero;
            }

        }

    }

    public Genero update(Genero genero) {
        if (genero.getIdGenero() != null) {
            Optional<Genero> evt = generoRepository.getGenero(genero.getIdGenero());
            if (!evt.isEmpty()) {
                if (genero.getGenero() != null) {
                    evt.get().setGenero(genero.getGenero());
                }
              generoRepository.save(evt.get());
                return evt.get();
            } else {
                return genero;
            }
        } else {
            return genero;
        }
    }

    public boolean deleteGenero(int IdGenero) {
        Boolean aBoolean = getGenero(IdGenero).map(genero -> {
            generoRepository.delete(genero);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
