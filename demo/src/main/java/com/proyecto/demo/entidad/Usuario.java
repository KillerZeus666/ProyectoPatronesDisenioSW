package com.proyecto.demo.entidad;

import java.util.Date;
import java.util.List;

public class Usuario {
    private String nombre;
    private long cedula;
    private long numero_celular;
    private String correo;
    private List<Queja> quejas;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String nombre, long cedula, long numero_celular, String correo, List<Queja> quejas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.numero_celular = numero_celular;
        this.correo = correo;
        this.quejas = quejas;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public long getNumero_celular() {
        return numero_celular;
    }

    public void setNumero_celular(long numero_celular) {
        this.numero_celular = numero_celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Queja> getQuejas() {
        return quejas;
    }

    public void setQuejas(List<Queja> quejas) {
        this.quejas = quejas;
    }
}
