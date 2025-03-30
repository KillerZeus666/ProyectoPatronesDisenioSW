package com.proyecto.demo.repositorio;

import com.proyecto.demo.entidad.Empresa;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
        Empresa findByNombreAndContraseña(String nombre, String contraseña);

}
