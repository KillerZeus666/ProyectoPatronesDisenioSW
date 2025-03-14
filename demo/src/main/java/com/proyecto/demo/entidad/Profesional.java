package com.proyecto.demo.entidad;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Profesional extends Usuario {

    @Column(nullable = false)
    private String tipoServicio;

    @Column(nullable = false)
    private String tipoQueja;

    @OneToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @OneToMany
    @JoinColumn(name = "profesional_id")
    private List<Incumplimiento> procesoIncumplimiento;

    // Constructor vacío
    public Profesional() {}

    // Constructor con parámetros
    public Profesional(String nombre, String correo, String contraseña, 
                       String tipoServicio, String tipoQueja, List<Incumplimiento> procesoIncumplimiento) {
        super(nombre, correo, contraseña);
        this.tipoServicio = tipoServicio;
        this.tipoQueja = tipoQueja;
        this.procesoIncumplimiento = procesoIncumplimiento;
    }

    // Getters
    public String getTipoServicio() {
        return tipoServicio;
    }

    public String getTipoQueja() {
        return tipoQueja;
    }

    public List<Incumplimiento> getProcesoIncumplimiento() {
        return procesoIncumplimiento;
    }

    // Setters
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public void setTipoQueja(String tipoQueja) {
        this.tipoQueja = tipoQueja;
    }

    public void setProcesoIncumplimiento(List<Incumplimiento> procesoIncumplimiento) {
        this.procesoIncumplimiento = procesoIncumplimiento;
    }
}
