package com.proyecto.demo.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.demo.entidad.EntidadVigilante;
import com.proyecto.demo.repositorio.EntidadVigilanteRepository;

@Service
public class EntidadVigilanteServiceImpl implements EntidadVigilanteService {

    @Autowired
    private EntidadVigilanteRepository entidadRepository;

    @Override
    public EntidadVigilante validarEntidad(String correo, String contraseña) {
        return entidadRepository.findByCorreoAndContraseña(correo, contraseña);
    }
}
