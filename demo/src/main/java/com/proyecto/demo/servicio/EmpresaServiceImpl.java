package com.proyecto.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.Usuario;
import com.proyecto.demo.repositorio.EmpresaRepository;
import com.proyecto.demo.repositorio.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> obtenerTodas() {
        return empresaRepository.findAll();
    }

    @Override
    public Optional<Empresa> obtenerPorId(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void eliminar(Long id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public Empresa validarEmpresa(String correo, String contraseña) {
        return empresaRepository.findByNombreAndContraseña(correo, contraseña);

    }
}
