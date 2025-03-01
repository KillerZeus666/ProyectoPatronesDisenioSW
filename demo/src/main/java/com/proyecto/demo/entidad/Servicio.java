package com.proyecto.demo.entidad;

public class Servicio {
    private long id; 
    private String tipo; 

    // Constructor vacío
    public Servicio() {}

    // Constructor con parámetros
    public Servicio(long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
