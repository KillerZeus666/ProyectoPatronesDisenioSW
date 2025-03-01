package com.proyecto.demo.entidad;

public class Empresa {
    private String nombre;
    private int id;

    // Constructor vacío
    public Empresa() {}

    // Constructor con parámetros
    public Empresa(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
