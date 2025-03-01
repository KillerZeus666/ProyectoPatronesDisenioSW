package com.proyecto.demo.entidad;

import java.util.List;

public class Empresa {
    private String nombre;
    private int id;
    private String contraseña; 
    private List<Servicio> servicios; 
    private List<Respuesta> respuestasEmitidas; 
    private List<Queja> quejas; 
    private List<Incumplimiento> procesoIncumplimiento; 

    // Constructor vacío
    public Empresa() {}

    // Constructor con parámetros
    public Empresa(String nombre, int id, String contraseña) {
        this.nombre = nombre;
        this.id = id;
        this.contraseña = contraseña;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public List<Respuesta> getRespuestasEmitidas() {
        return respuestasEmitidas;
    }

    public List<Queja> getQuejas() {
        return quejas;
    }

    public List<Incumplimiento> getProcesoIncumplimiento() {
        return procesoIncumplimiento;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public void setRespuestasEmitidas(List<Respuesta> respuestasEmitidas) {
        this.respuestasEmitidas = respuestasEmitidas;
    }

    public void setQuejas(List<Queja> quejas) {
        this.quejas = quejas;
    }

    public void setProcesoIncumplimiento(List<Incumplimiento> procesoIncumplimiento) {
        this.procesoIncumplimiento = procesoIncumplimiento;
    }
}
