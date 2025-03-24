package com.proyecto.demo.repositorio;

import com.proyecto.demo.entidad.EntidadVigilante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadVigilanteRepository extends JpaRepository<EntidadVigilante, Long> {

    EntidadVigilante findByCorreoAndContraseña(String correo, String contraseña);
}
