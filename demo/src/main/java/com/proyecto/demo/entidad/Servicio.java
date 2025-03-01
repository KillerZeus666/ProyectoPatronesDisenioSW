package com.proyecto.demo.entidad;

import jakarta.persistence.*;

@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    @Column(nullable = false, length = 100)
    private String tipo; 

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    // Constructor vacío
    public Servicio() {}

    // Constructor con parámetros
    public Servicio(String tipo, Empresa empresa) {
        this.tipo = tipo;
        this.empresa = empresa;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
