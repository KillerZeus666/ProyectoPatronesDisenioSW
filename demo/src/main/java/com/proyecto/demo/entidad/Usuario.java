package com.proyecto.demo.entidad;

public class Usuario {
    private String nombre;
    private long cedula;
    private long numero_celular;
    private String correo;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String nombre, long cedula, long numero_celular, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.numero_celular = numero_celular;
        this.correo = correo;
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
}