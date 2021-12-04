/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.repository;

import com.hackaton.huella.crudRepository.UsuarioCrudRepository;
import com.hackaton.huella.model.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cjop1
 */
@Repository
public class UsuarioRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    /**
     * READ
     */
    public List<Usuario> getAll() {
        return (List<Usuario>) usuarioCrudRepository.findAll();
    }

    /**
     * READ by Id
     */
    public Optional<Usuario> getUsuario(int idUsuario) {
        return usuarioCrudRepository.findById(idUsuario);
    }

    /**
     * CREATE AND UPDATE
     */
    public Usuario save(Usuario usuario) {
        return usuarioCrudRepository.save(usuario);
    }

    /**
     * DELETE
     */
    public void delete(Usuario usuario) {
        usuarioCrudRepository.delete(usuario);
    }
}
