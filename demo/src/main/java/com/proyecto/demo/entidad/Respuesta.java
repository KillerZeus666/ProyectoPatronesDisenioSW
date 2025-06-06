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
    @JoinColumn(name = "empresa_id") 
    private Empresa empresa;

    @OneToOne
    @JoinColumn(name = "queja_id")
    private Queja queja;

    // Constructor vacío
    public Respuesta() {}

    // Constructor con parámetros
    public Respuesta(Date fecha, String descripcion, Empresa empresa) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.empresa = empresa;
    }


    public Respuesta(Date fechaRespuesta, String descripcion, Empresa empresa, Queja queja) {
        this.fecha = fechaRespuesta;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.queja = queja;
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
    public Queja getQueja() {
        return queja;
    }
    
    public void setQueja(Queja queja) {
        this.queja = queja;
    }
    
}
