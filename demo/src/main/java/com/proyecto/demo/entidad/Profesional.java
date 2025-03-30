package com.proyecto.demo.entidad;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("PROFESIONAL")
public class Profesional extends Usuario {

    @ManyToOne 
    @JoinColumn(name = "tipoqueja_id", nullable = false)
    private TipoQueja tipo;

    //Un servicio puede tener múltiples profesionales
    @ManyToOne 
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @Column(name = "carga_trabajo", nullable = false)
    private Integer cargaTrabajo = 0;

    @OneToMany(mappedBy = "profesionalAsignado")
    private List<Incumplimiento> incumplimientosAsignados = new ArrayList<>();

    // Constructor vacío
    public Profesional() {}

    // Constructor que utiliza el constructor de Usuario
    public Profesional(String nombre, long cedula, long numeroCelular, String correo, String contraseña,
                       Servicio servicio, TipoQueja tipo) {
        super(nombre, cedula, numeroCelular, correo, contraseña);
        this.servicio = servicio;
        this.tipo = tipo;
    }

    // Getters y Setters
    public Servicio getServicio() {
        return servicio;
    }

    public TipoQueja getTipo() {
        return tipo;
    }

    public List<Incumplimiento> getIncumplimientosAsignados() {
        return incumplimientosAsignados;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setTipo(TipoQueja tipo) {
        this.tipo = tipo;
    }

    public void setIncumplimientosAsignados(List<Incumplimiento> incumplimientosAsignados) {
        this.incumplimientosAsignados = incumplimientosAsignados;
    }

    // Actualizar la carga
    public void incrementarCargaTrabajo() {
        this.cargaTrabajo++;
    }

    public void decrementarCargaTrabajo() {
        if (this.cargaTrabajo > 0) {
            this.cargaTrabajo--;
        }
    }

    public int getCargaTrabajo() {
        return cargaTrabajo;
    }
}
