package com.proyecto.demo.entidad;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "empresa_id") // Asegúrate de que el nombre coincida con la base de datos
    private Empresa empresa;

    // Constructor vacío
    public Respuesta() {}

    // Constructor con parámetros
    public Respuesta(Date fecha, String descripcion, Empresa empresa) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.empresa = empresa;
    }

    // Getters
    public long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
