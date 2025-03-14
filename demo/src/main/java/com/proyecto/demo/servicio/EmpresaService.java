package com.proyecto.demo.servicio;

import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.Usuario;

public interface EmpresaService {
    Empresa validarEmpresa(String correo, String contraseña);


}
