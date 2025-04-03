package com.proyecto.demo.servicio;

import java.util.List;

import com.proyecto.demo.entidad.EntidadVigilante;

public interface EntidadVigilanteService {
    public List<EntidadVigilante> obtenerTodas();

    EntidadVigilante validarEntidad(String correo, String contraseña);
}
