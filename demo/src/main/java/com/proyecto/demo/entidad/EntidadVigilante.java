package com.proyecto.demo.entidad;

import java.util.List;

public class EntidadVigilante {
    private String nombre;
    private long nit;
    private String contraseña; 
    private String correo;
    private List<Empresa> empresas; 

    // Constructor vacío
    public EntidadVigilante() {}

    // Constructor con parámetros
    public EntidadVigilante(String nombre, long nit, String correo, String contraseña) {
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
        this.contraseña = contraseña;
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

    public String getContraseña() {
        return contraseña;
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

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
}
