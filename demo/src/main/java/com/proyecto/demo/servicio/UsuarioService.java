package com.proyecto.demo.servicio;

import com.proyecto.demo.entidad.Usuario;

public interface UsuarioService {
    Usuario validarUsuario(String correo, String contraseña);

}
