package com.proyecto.demo.repositorio;

import com.proyecto.demo.entidad.Incumplimiento; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncumplimientoRepository extends JpaRepository<Incumplimiento, Long> {

}
