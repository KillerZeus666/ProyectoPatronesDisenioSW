package com.proyecto.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.Usuario;
import com.proyecto.demo.repositorio.EmpresaRepository;
import com.proyecto.demo.repositorio.UsuarioRepository; 

@Service
public class EmpresaServiceImpl implements EmpresaService{
    @Autowired 
    EmpresaRepository empresaRepository; 
 
    @Override
    public Empresa validarEmpresa(String correo, String contraseña){
        return empresaRepository.findByNombreAndContraseña(correo, contraseña);

    }
}
