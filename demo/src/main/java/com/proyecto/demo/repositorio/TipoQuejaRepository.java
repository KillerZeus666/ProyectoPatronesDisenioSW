package com.proyecto.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.demo.entidad.TipoQueja;

@Repository
public interface TipoQuejaRepository extends JpaRepository<TipoQueja, Long> {
    TipoQueja findByDescripcion(String descripcion);

    @Transactional
    @Modifying
    @Query("UPDATE TipoQueja t SET t.tiempoAtencion = :tiempoAtencion WHERE t.id = :id")
    void actualizarTiempoAtencion(Long id, int tiempoAtencion);
}