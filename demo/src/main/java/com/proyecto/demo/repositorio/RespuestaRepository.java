package com.proyecto.demo.repositorio;

import com.proyecto.demo.entidad.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    List<Respuesta> findByQueja_Id(Long quejaId);
    List<Respuesta> findByEmpresa_Id(Long empresaId);

    @Query("SELECT r FROM Respuesta r JOIN r.queja q WHERE q.usuario.id = :cedula")
    List<Respuesta> findRespuestasByUsuarioCedula(@Param("cedula") Long cedula);
    List<Respuesta> findByQuejaId(Long idQueja);

}
