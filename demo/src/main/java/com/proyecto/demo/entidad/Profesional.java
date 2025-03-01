package com.proyecto.demo.entidad;

public class Profesional extends Usuario {
    private String tipo_servicio;
    private String tipo_queja;

    // Constructor vacío
    public Profesional() {}

    // Constructor con parámetros
    public Profesional(String tipo_servicio, String tipo_queja) {
        this.tipo_servicio = tipo_servicio;
        this.tipo_queja = tipo_queja;
    }

    // Getters y Setters
    public String getTipoServicio() {
        return tipo_servicio;
    }

    public void setTipoServicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public String getTipoQueja() {
        return tipo_queja;
    }

    public void setTipoQueja(String tipo_queja) {
        this.tipo_queja = tipo_queja;
    }
}
