package com.proyecto.demo.servicio;

import java.util.List;

import com.proyecto.demo.entidad.Servicio;

public interface ServicioService {
    
    /*
   public Servicio SearchById(int id); 
    */

    public List<Servicio> obtenerTodosLosServicios();
}
