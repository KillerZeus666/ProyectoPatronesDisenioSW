package com.proyecto.demo.entidad;

import java.util.List;

public class Profesional extends Usuario {
    private String tipo_servicio;
    private String tipo_queja;
    private List<Incumplimiento> procesoIncumplimiento; 

    // Constructor vacío
    public Profesional() {}

    // Constructor con los nuevos parámetros
    public Profesional(String nombre, String correo, String contraseña, String tipo_servicio, String tipo_queja, List<Incumplimiento> procesoIncumplimiento) {
        super(nombre, correo, contraseña);
        this.tipo_servicio = tipo_servicio;
        this.tipo_queja = tipo_queja;
        this.procesoIncumplimiento = procesoIncumplimiento;
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

    public List<Incumplimiento> getProcesoIncumplimiento() {
        return procesoIncumplimiento;
    }

    public void setProcesoIncumplimiento(List<Incumplimiento> procesoIncumplimiento) {
        this.procesoIncumplimiento = procesoIncumplimiento;
    }
}
