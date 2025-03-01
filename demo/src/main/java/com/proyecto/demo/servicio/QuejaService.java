package com.proyecto.demo.servicio;

import com.proyecto.demo.entidad.Queja;
import java.util.Date;
import java.util.List;

public interface QuejaService {
    
    // Registrar una nueva queja
    Queja registrarQueja(Long id, Date fecha, String tipo, String descripcion, Long idServicio);

    // Buscar una queja por ID
    Queja buscarQueja(Long id);

    // Ver todas las quejas por cédula del usuario
    List<Queja> verQuejasPorUsr(Long cedula);
}
