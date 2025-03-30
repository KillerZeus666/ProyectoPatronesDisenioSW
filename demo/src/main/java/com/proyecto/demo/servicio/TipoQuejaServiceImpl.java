package com.proyecto.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.TipoQueja;
import com.proyecto.demo.repositorio.TipoQuejaRepository;

@Service
public class TipoQuejaServiceImpl implements TipoQuejaService {

    @Autowired
    private TipoQuejaRepository tipoQuejaRepository;
    //Buscar por descripcion del tipo de queja
    @Override
    public TipoQueja buscarTipoQueja(String descripcion) {
        return tipoQuejaRepository.findByDescripcion(descripcion);
    }
    
    @Override
    public List<TipoQueja> obtenerTodosLosTiposQueja() {
        return tipoQuejaRepository.findAll();
    }

    @Override
    public void actualizarTiempoAtencion(Long id, int nuevoTiempo) {
        TipoQueja tipoQueja = tipoQuejaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tipo de queja no encontrado"));
        tipoQueja.setTiempoAtencion(nuevoTiempo);
        tipoQuejaRepository.save(tipoQueja);
    }

}
