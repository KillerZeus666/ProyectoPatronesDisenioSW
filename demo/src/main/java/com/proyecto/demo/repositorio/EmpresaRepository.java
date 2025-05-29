package com.proyecto.demo.repositorio;

import com.proyecto.demo.entidad.Empresa;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
        Empresa findByNombreAndContraseña(String nombre, String contraseña);
        @Query("SELECT e FROM Empresa e ORDER BY e.id ASC")
        List<Empresa> findAllOrderedById();
}
