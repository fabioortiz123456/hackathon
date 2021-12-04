/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.services;

import com.hackaton.huella.model.Usuario;
import com.hackaton.huella.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cjop1
 */
@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.getAll();
    }

    public Optional<Usuario> getUsuario(int idUsuario) {
        return usuarioRepository.getUsuario(idUsuario);
    }

    public Usuario save(Usuario usuario) {
        if (usuario.getIdUsuario() == null) {
            return usuarioRepository.save(usuario);
        } else {
            Optional<Usuario> evt = usuarioRepository.getUsuario(usuario.getIdUsuario());
            if (evt.isEmpty()) {
                return usuarioRepository.save(usuario);
            } else {
                return usuario;
            }
            

        }

    }

    public Usuario update(Usuario usuario) {
        if (usuario.getIdUsuario() != null) {
            Optional<Usuario> evt = usuarioRepository.getUsuario(usuario.getIdUsuario());
            if (!evt.isEmpty()) {
                if (usuario.getNombre() != null) {
                    evt.get().setNombre(usuario.getNombre());
                }
                if (usuario.getFechaNacimiento() != null) {
                    evt.get().setFechaNacimiento(usuario.getFechaNacimiento());
                }
                if (usuario.getGenero() != null) {
                    evt.get().setEmail(usuario.getEmail());
                }
                if (usuario.getPassword()!= null) {
                    evt.get().setPassword(usuario.getPassword());
                }
                if (usuario.getViajes()!= null) {
                    evt.get().setViajes(usuario.getViajes());
                }
                if (usuario.getVehiculo() != null) {
                    evt.get().setVehiculo(usuario.getVehiculo());
                }
                usuarioRepository.save(evt.get());
                return evt.get();
            } else {
                return usuario;
            }
        } else {
            return usuario;
        }
    }

    public boolean deleteUsuario(int IdUsuario) {
        Boolean aBoolean = getUsuario(IdUsuario).map(usuario -> {
            usuarioRepository.delete(usuario);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
