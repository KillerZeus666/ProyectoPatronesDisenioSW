package com.proyecto.demo.entidad;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class EntidadVigilante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false, unique = true)
    private long nit;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String contraseña; 

    @OneToMany(mappedBy = "entidadVigilante", cascade = CascadeType.ALL)
    private List<Empresa> empresas;

    // Constructor vacío
    public EntidadVigilante() {}

    // Constructor con parámetros
    public EntidadVigilante(String nombre, long nit, String correo, String contraseña) {
        this.nombre = nombre;
        this.nit = nit;
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

    public long getNit() {
        return nit;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
}
