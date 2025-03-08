package com.proyecto.demo.entidad;

import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Queja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Constructor vacío
    public Queja() {}


    public Queja(Date fecha, String tipo, String descripcion, Servicio servicio, Empresa empresa) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.servicio = servicio;
        this.empresa = empresa;
        this.usuario = null; // Se asigna null por defecto
    }
    

    public Queja(Date fecha, String tipo, String descripcion, Servicio servicio, Empresa empresa, Usuario usuario) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.servicio = servicio;
        this.empresa = empresa;
        this.usuario = usuario;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Asigna la fecha automáticamente antes de persistir
    @PrePersist
    protected void asignarFechaActual() {
        if (this.fecha == null) {
            this.fecha = new Date();
        }
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "Queja{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", servicio=" + (servicio != null ? servicio.getId() : "null") +
                ", empresa=" + (empresa != null ? empresa.getId() : "null") +
                ", usuario=" + (usuario != null ? usuario.getId() + " - " + usuario.getNombre() : "null") +
                '}';
    }
}
