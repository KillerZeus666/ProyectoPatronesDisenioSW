package com.proyecto.demo.entidad;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profesional extends Usuario {

    @ManyToOne 
    @JoinColumn(name = "tipoqueja_id", nullable = false)
    private TipoQueja tipo;

    @OneToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @OneToMany
    @JoinColumn(name = "profesional_id")
    private List<Incumplimiento> procesoIncumplimiento;

    // Constructor vacío
    public Profesional() {}

    // Constructor que utiliza el constructor de Usuario
    public Profesional(String nombre, long cedula, long numeroCelular, String correo, String contraseña,
                       Servicio servicio, TipoQueja tipo) {
        super(nombre, cedula, numeroCelular, correo, contraseña);
        this.servicio = servicio;
        this.tipo = tipo;
        this.procesoIncumplimiento = new ArrayList<>();
    }

    // Getters y Setters
    public Servicio getServicio() {
        return servicio;
    }

    public TipoQueja getTipo() {
        return tipo;
    }

    public List<Incumplimiento> getProcesoIncumplimiento() {
        return procesoIncumplimiento;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setTipo(TipoQueja tipo) {
        this.tipo = tipo;
    }

    public void setProcesoIncumplimiento(List<Incumplimiento> procesoIncumplimiento) {
        this.procesoIncumplimiento = procesoIncumplimiento;
    }
}
