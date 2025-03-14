package com.proyecto.demo.repositorio;

import com.proyecto.demo.entidad.Queja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuejaRepository extends JpaRepository<Queja, Long> {

    List<Queja> findByUsuario_Cedula(Long cedula);
    List<Queja> findByEmpresa_Id(Long empresaId);

}
