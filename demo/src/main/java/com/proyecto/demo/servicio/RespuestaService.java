package com.proyecto.demo.servicio;

import com.proyecto.demo.entidad.Respuesta; 

public interface RespuestaService {

	Respuesta registrarRespuesta(Long id, String descripcion, Long idEmpresa, Long idQueja);

    Respuesta buscarRespuesta(Long id);

    Respuesta verRespuestasPorQueja(Long id);

    Respuesta buscarRespuestasPorEmpresa(Long id);
    
    /*
   public Respuesta SearchById(int id); 
    */
}
