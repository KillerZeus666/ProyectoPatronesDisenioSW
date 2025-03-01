package com.proyecto.demo.entidad;

import java.util.List;

public class EntidadVigilante {
    private String nombre;
    private long nit;
    private String correo;
    private List<Empresa> empresas; 

    // Constructor vacío
    public EntidadVigilante() {}

    // Constructor con parámetros
    public EntidadVigilante(String nombre, long nit, String correo) {
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public long getNit() {
        return nit;
    }

    public String getCorreo() {
        return correo;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
}
