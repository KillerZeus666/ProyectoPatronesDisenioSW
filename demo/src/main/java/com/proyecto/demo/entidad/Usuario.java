package com.proyecto.demo.entidad;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(unique = true, nullable = false)
    private long cedula;

    @Column(unique = true, nullable = false)
    private long numeroCelular;

    @Column(unique = true, nullable = false)
    private String correo;

    @Column(nullable = false)
    private String contraseña;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Queja> quejas;

    // Constructor vacío
    public Usuario() {}

    // Constructor con todos los parámetros
    public Usuario(String nombre, long cedula, long numeroCelular, String correo, String contraseña, List<Queja> quejas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.numeroCelular = numeroCelular;
        this.correo = correo;
        this.contraseña = contraseña;
        this.quejas = quejas;
    }

    // Constructor con lista de quejas vacía
    public Usuario(String nombre, long cedula, long numeroCelular, String correo, String contraseña) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.numeroCelular = numeroCelular;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public long getNumeroCelular() {
        return numeroCelular;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public List<Queja> getQuejas() {
        return quejas;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public void setNumeroCelular(long numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setQuejas(List<Queja> quejas) {
        this.quejas = quejas;
    }
}
