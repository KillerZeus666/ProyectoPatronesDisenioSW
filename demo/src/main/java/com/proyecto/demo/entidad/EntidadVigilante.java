package com.proyecto.demo.entidad;

public class EntidadVigilante {
    private String nombre;
    private long nit;
    private String correo;

    // Constructor vacío
    public EntidadVigilante() {}

    // Constructor con parámetros
    public EntidadVigilante(String nombre, long nit, String correo) {
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
