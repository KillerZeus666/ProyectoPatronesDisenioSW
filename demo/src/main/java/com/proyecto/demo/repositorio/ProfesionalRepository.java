package com.proyecto.demo.repositorio;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.EntidadVigilante;
import com.proyecto.demo.entidad.Incumplimiento;
import com.proyecto.demo.entidad.Profesional;
import com.proyecto.demo.entidad.Servicio;
import com.proyecto.demo.entidad.TipoQueja;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {
    // Busca profesionales por servicio y tipo de queja
    List<Profesional> findByServicioAndTipo(Servicio servicio, TipoQueja tipo);

    Profesional findByCorreoAndContraseña(String correo, String contraseña);

}
