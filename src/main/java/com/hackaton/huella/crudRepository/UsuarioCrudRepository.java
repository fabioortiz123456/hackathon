/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hackaton.huella.crudRepository;

import com.hackaton.huella.model.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author cjop1
 */
public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer>{
    
}
