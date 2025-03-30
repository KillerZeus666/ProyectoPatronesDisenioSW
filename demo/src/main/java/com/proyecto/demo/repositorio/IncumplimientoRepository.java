package com.proyecto.demo.repositorio;

import com.proyecto.demo.entidad.Incumplimiento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncumplimientoRepository extends JpaRepository<Incumplimiento, Long> {

    List<Incumplimiento> findByProfesionalAsignadoIsNull();
    List<Incumplimiento> findByEmpresa_Id(Long empresaId);
}
