package com.proyecto.demo.servicio;

import com.proyecto.demo.entidad.TipoQueja;

public interface ServiceTipoQueja {
    //Buscar por descripcion del tipo de queja
    public TipoQueja buscarTipoQueja(String descripcion);
}
