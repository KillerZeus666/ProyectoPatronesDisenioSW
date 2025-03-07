package com.proyecto.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.Usuario;
import com.proyecto.demo.repositorio.UsuarioRepository; 


@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired 
    UsuarioRepository usuarioRepository; 
   
    @Override
    public Usuario validarUsuario(String correo, String contraseña) {
        return usuarioRepository.findByCorreoAndContraseña(correo, contraseña);
    }
    
}
