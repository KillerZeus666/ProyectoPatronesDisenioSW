package com.proyecto.demo.servicio;

import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.entidad.Respuesta;
import java.util.List;

public interface RespuestaService {

    Respuesta registrarRespuesta(String descripcion, Long idEmpresa, Long idQueja);

    Respuesta buscarRespuesta(Long id);

    List<Respuesta> verRespuestasPorQueja(Long idQueja);

    List<Respuesta> buscarRespuestasPorEmpresa(Long idEmpresa);

      // Ver todas las quejas de la BD
    List<Respuesta> obtenerTodasLasRespuestas();
}
