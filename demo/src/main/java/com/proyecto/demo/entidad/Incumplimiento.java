package com.proyecto.demo.entidad;

public class Incumplimiento {
    private long id;
    private String descripcion;
    private Queja queja; 

    // Constructor vacío
    public Incumplimiento() {}

    // Constructor con parámetros
    public Incumplimiento(long id, String descripcion, Queja queja) {
        this.id = id;
        this.descripcion = descripcion;
        this.queja = queja;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Queja getQueja() {
        return queja;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setQueja(Queja queja) {
        this.queja = queja;
    }
}
