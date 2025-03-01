package com.proyecto.demo.servicio;

import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.entidad.Servicio;
import com.proyecto.demo.repositorio.QuejaRepository;
import com.proyecto.demo.repositorio.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class QuejaServiceImpl implements QuejaService {

    @Autowired
    private QuejaRepository quejaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public Queja registrarQueja(Long id, Date fecha, String tipo, String descripcion, Long idServicio) {
        Servicio servicio = servicioRepository.findById(idServicio).orElse(null);
        if (servicio == null) {
            throw new IllegalArgumentException("El servicio especificado no existe");
        }
        Queja nuevaQueja = new Queja(fecha, tipo, descripcion, servicio, null); 
        return quejaRepository.save(nuevaQueja);
    }

    @Override
    public Queja buscarQueja(Long id) {
        return quejaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Queja> verQuejasPorUsr(Long cedula) {
        return quejaRepository.findByServicio_Usuario_Cedula(cedula);
    }
}
