package com.proyecto.demo.servicio;

import java.util.List;

import com.proyecto.demo.entidad.TipoQueja;

public interface TipoQuejaService {
    // Buscar por descripcion del tipo de queja
    public TipoQueja buscarTipoQueja(String descripcion);

    public List<TipoQueja> obtenerTodosLosTiposQueja();

    public void actualizarTiempoAtencion(Long id, int nuevoTiempo);
}