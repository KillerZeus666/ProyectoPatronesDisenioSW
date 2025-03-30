package com.proyecto.demo.servicio;

import java.util.List;

import java.util.List;

import com.proyecto.demo.entidad.Servicio;

public interface ServicioService {

    public List<Servicio> obtenerTodos();

    public void actualizarEmpresa(Long servicioId, Long empresaId);
}
