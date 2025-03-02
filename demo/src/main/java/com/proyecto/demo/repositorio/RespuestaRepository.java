package com.proyecto.demo.repositorio;

import com.proyecto.demo.entidad.Respuesta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    public Respuesta findByQueja_Id(Long id);

    public Respuesta findByEmpresa_Id(Long id);
    
    /*
    public Respuesta findById(int id){
    return respuesta.get(id); 
    }
    */
}
