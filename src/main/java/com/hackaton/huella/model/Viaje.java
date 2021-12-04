/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaton.huella.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author cjop1
 */
@Entity
@Table(name = "Viaje")
public class Viaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idViaje;
    private Date FechaViaje;
    private float distancia;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    @JsonIgnoreProperties({"viajes", "usuario"})
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idVehiculo")
    @JsonIgnoreProperties({"viajes", "vehiculo"})
    private Vehiculo vehiculo;

    public Viaje() {
    }

    public Viaje(Integer idViaje, Date FechaViaje, float distancia, Usuario usuario, Vehiculo vehiculo) {
        this.idViaje = idViaje;
        this.FechaViaje = FechaViaje;
        this.distancia = distancia;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public Date getFechaViaje() {
        return FechaViaje;
    }

    public void setFechaViaje(Date FechaViaje) {
        this.FechaViaje = FechaViaje;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    

}
