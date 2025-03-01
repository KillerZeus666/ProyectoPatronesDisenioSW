package com.proyecto.demo.repositorio;

import com.proyecto.demo.entidad.Queja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuejaRepository extends JpaRepository<Queja, Long> {

    List<Queja> findByUsuario_Cedula(Long cedula);
    List<Queja> findByServicio_Usuario_Cedula(Long cedula);



    // Buscar una queja por ID
    //Queja findById(long id);

    // Listar todas las quejas asociadas a un usuario por su cédula
    //List<Queja> findByServicio_Usuario_Cedula(long cedula);
}
