package com.proyecto.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.Usuario;

public interface EmpresaService {

    public List<Empresa> obtenerTodas();

    public Optional<Empresa> obtenerPorId(Long id);

    public Empresa guardar(Empresa empresa);

    public void eliminar(Long id);

    Empresa validarEmpresa(String correo, String contraseña);

}
