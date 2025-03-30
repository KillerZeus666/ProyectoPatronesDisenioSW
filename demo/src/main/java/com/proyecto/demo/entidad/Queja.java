package com.proyecto.demo.entidad;

import java.util.Calendar;
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

    @ManyToOne 
    @JoinColumn(name = "tipoqueja_id", nullable = false)
    private TipoQueja tipo;

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

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean procesada = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaLimite;

    // Constructor vacío
    public Queja() {
    }

    public Queja(Date fecha, TipoQueja tipo, String descripcion, Servicio servicio, Empresa empresa) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.servicio = servicio;
        this.empresa = empresa;
        this.usuario = null; // Se asigna null por defecto
    }

    public Queja(Date fecha, TipoQueja tipo, String descripcion, Servicio servicio, Empresa empresa, Usuario usuario) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.servicio = servicio;
        this.empresa = empresa;
        this.usuario = usuario;
        this.fechaLimite = calcularFechaLimite(fecha);
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

    public TipoQueja getTipo() {
        return tipo;
    }

    public void setTipo(TipoQueja tipo) {
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

    public boolean isProcesada() {
        return procesada;
    }

    public void setProcesada(boolean procesada) {
        this.procesada = procesada;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    private Date calcularFechaLimite(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_MONTH, 15); // Suma 15 días
        return calendar.getTime();
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "Queja{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", tipo=" + (tipo != null ? tipo.getDescripcion() : "null") + // Usar getDescripcion()
                ", descripcion='" + descripcion + '\'' +
                ", servicio=" + (servicio != null ? servicio.getId() : "null") +
                ", empresa=" + (empresa != null ? empresa.getId() : "null") +
                ", usuario=" + (usuario != null ? usuario.getId() + " - " + usuario.getNombre() : "null") +
                '}';
    }
}
