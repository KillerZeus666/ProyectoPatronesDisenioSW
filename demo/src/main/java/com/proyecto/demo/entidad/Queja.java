package com.proyecto.demo.entidad;

import java.util.Date;

public class Queja {
    private Long id;
    private Date fecha;
    private String tipo;
    private String descripcion;
    private Servicio servicio; 

    // Constructor vacío
    public Queja() {}

    // Constructor con parámetros
    public Queja(Long id, Date fecha, String tipo, String descripcion, Servicio servicio) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.servicio = servicio;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Servicio getServicio() {
        return servicio;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
