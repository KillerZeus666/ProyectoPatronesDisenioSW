package com.proyecto.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.Servicio;
import com.proyecto.demo.repositorio.ServicioRepository; 

@Service
public class ServicioServiceImpl implements ServicioService{
    @Autowired 
    ServicioRepository ServicioRepository; 


    @Override
    public List<Servicio> obtenerTodosLosServicios() {
        return ServicioRepository.findAll();
    }
}
