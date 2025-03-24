package com.proyecto.demo.servicio;

import com.proyecto.demo.entidad.EntidadVigilante;

public interface EntidadVigilanteService {
    EntidadVigilante validarEntidad(String correo, String contraseña);
}
