package com.proyecto.demo.repositorio;

import com.proyecto.demo.entidad.Profesional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {
    
    /*
    public Profesional findById(int id){
    return Profesional.get(id); 
    }
    */
}
