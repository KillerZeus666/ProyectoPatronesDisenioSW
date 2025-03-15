package com.proyecto.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.TipoQueja;
import com.proyecto.demo.repositorio.TipoQuejaRepository;

@Service
public class ServiceTipoQuejaImpl implements ServiceTipoQueja {

    @Autowired
    private TipoQuejaRepository tipoQuejaRepository;
    //Buscar por descripcion del tipo de queja
    public TipoQueja buscarTipoQueja(String descripcion) {
        return tipoQuejaRepository.findByDescripcion(descripcion);
    }
}
