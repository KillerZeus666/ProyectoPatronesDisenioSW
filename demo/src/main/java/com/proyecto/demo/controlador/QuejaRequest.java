package com.proyecto.demo.controlador;

import org.springframework.format.annotation.DateTimeFormat;

import com.proyecto.demo.entidad.TipoQueja;

import java.util.Date;

public class QuejaRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    private TipoQueja tipo;
    private String descripcion;
    private Long idServicio;
    private Long idEmpresa;
    private Long idUsuario;

    // Getters y Setters
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

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
