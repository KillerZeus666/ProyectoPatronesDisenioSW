package com.proyecto.demo.repositorio;

import com.proyecto.demo.entidad.Profesional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {
    @Query("SELECT p FROM Profesional p ORDER BY p.cargaTrabajo ASC")
    Profesional findProfesionalConMenorCarga();

    List<Profesional> findAllByOrderByCargaTrabajoAsc();
}
