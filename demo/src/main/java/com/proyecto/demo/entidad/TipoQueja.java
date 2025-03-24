package com.proyecto.demo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TipoQueja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 3")
    private int tiempoAtencion = 3; // Valor por defecto

    public TipoQueja() {
    } // Constructor sin argumentos

    public TipoQueja(String descripcion, int tiempoAtencion) {
        this.descripcion = descripcion;
        this.tiempoAtencion = tiempoAtencion;
    }

    // Getters and Setters
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

    public int getTiempoAtencion() {
        return this.tiempoAtencion;
    }

    public void setTiempoAtencion(int tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

}