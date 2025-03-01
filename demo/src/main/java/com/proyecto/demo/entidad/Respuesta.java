package com.proyecto.demo.entidad;

import java.util.Date;

public class Respuesta {
    private long id;
    private Date fecha;
    private String descripcion;

    // Constructor vacío
    public Respuesta() {}

    // Constructor con parámetros
    public Respuesta(long id, Date fecha, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
