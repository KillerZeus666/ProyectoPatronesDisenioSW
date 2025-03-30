package com.proyecto.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.demo.entidad.TipoQueja;

@Repository
public interface TipoQuejaRepository extends JpaRepository<TipoQueja, Long> {
    TipoQueja findByDescripcion(String descripcion);
}