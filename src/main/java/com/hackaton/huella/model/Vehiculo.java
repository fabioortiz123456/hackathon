/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author cjop1
 */
@Entity
@Table(name = "Vehiculo")
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculo;
    private String vehiculo;
    private String caractVehiculo;
    private float huellaCarbono;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "vehiculo")
    @JsonIgnoreProperties("vehiculo")
    private List<Viaje> viajes;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "vehiculo")
    @JsonIgnoreProperties("vehiculo")
    private List<Usuario> usuarios;

    public Vehiculo() {
    }

    public Vehiculo(Integer idVehiculo, String vehiculo, String caractVehiculo, float huellaCarbono, List<Viaje> viajes, List<Usuario> usuarios) {
        this.idVehiculo = idVehiculo;
        this.vehiculo = vehiculo;
        this.caractVehiculo = caractVehiculo;
        this.huellaCarbono = huellaCarbono;
        this.viajes = viajes;
        this.usuarios = usuarios;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getCaractVehiculo() {
        return caractVehiculo;
    }

    public void setCaractVehiculo(String caractVehiculo) {
        this.caractVehiculo = caractVehiculo;
    }

    public float getHuellaCarbono() {
        return huellaCarbono;
    }

    public void setHuellaCarbono(float huellaCarbono) {
        this.huellaCarbono = huellaCarbono;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
