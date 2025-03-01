package com.proyecto.demo.entidad;

public class Incumplimiento {
    private long id;
    private String descripcion;

    // Constructor vacío
    public Incumplimiento() {}

    // Constructor con parámetros
    public Incumplimiento(long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
