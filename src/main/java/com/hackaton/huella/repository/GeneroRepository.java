/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.repository;

import com.hackaton.huella.crudRepository.GeneroCrudRepository;
import com.hackaton.huella.model.Genero;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cjop1
 */
@Repository
public class GeneroRepository {

    @Autowired
    private GeneroCrudRepository generoCrudRepository;

    /**
     * READ
     */
    public List<Genero> getAll() {
        return (List<Genero>) generoCrudRepository.findAll();
    }

    /**
     * READ by Id
     */
    public Optional<Genero> getGenero(int idGenero) {
        return generoCrudRepository.findById(idGenero);
    }

    /**
     * CREATE AND UPDATE
     */
    public Genero save(Genero genero) {
        return generoCrudRepository.save(genero);
    }

    /**
     * DELETE
     */
    public void delete(Genero genero) {
        generoCrudRepository.delete(genero);
    }
}
