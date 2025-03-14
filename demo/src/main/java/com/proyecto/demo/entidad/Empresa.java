package com.proyecto.demo.entidad;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String contraseña;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Servicio> servicios;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Respuesta> respuestasEmitidas;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Queja> quejas;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Incumplimiento> procesoIncumplimiento;

    @ManyToOne
    @JoinColumn(name = "entidad_vigilante_id")
    private EntidadVigilante entidadVigilante;

    // Constructor vacío
    public Empresa() {}

    // Constructor con parámetros
    public Empresa(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcontraseña() {
        return contraseña;
    }

    public void setcontraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<Respuesta> getRespuestasEmitidas() {
        return respuestasEmitidas;
    }

    public void setRespuestasEmitidas(List<Respuesta> respuestasEmitidas) {
        this.respuestasEmitidas = respuestasEmitidas;
    }

    public List<Queja> getQuejas() {
        return quejas;
    }

    public void setQuejas(List<Queja> quejas) {
        this.quejas = quejas;
    }

    public List<Incumplimiento> getProcesoIncumplimiento() {
        return procesoIncumplimiento;
    }

    public void setProcesoIncumplimiento(List<Incumplimiento> procesoIncumplimiento) {
        this.procesoIncumplimiento = procesoIncumplimiento;
    }

    public EntidadVigilante getEntidadVigilante() {
        return entidadVigilante;
    }

    public void setEntidadVigilante(EntidadVigilante entidadVigilante) {
        this.entidadVigilante = entidadVigilante;
    }
}
