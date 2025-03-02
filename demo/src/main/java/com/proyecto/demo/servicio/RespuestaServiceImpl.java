package com.proyecto.demo.servicio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.entidad.Respuesta;
import com.proyecto.demo.repositorio.EmpresaRepository;
import com.proyecto.demo.repositorio.RespuestaRepository; 

@Service
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    private QuejaService quejaService;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Respuesta registrarRespuesta(Long id, String descripcion, Long idEmpresa, Long idQueja) {
            Queja queja = quejaService.buscarQueja(idQueja);
            Empresa empresa = empresaRepository.findById(idEmpresa).orElse(null);
            
            if (queja == null) {
                throw new IllegalArgumentException("La queja especificada no existe");
            }
            if (empresa == null) {
                throw new IllegalArgumentException("La empresa especificada no existe");
            }
            Date fechaRespuesta = new Date();
    
            Respuesta nuevaRespuesta = new Respuesta(fechaRespuesta,descripcion, empresa, queja);
            return respuestaRepository.save(nuevaRespuesta);
        }
    
    @Override
    public Respuesta buscarRespuesta(Long id) {
        return respuestaRepository.findById(id).orElse(null);
    }

    @Override
    public Respuesta verRespuestasPorQueja(Long id) {
        return respuestaRepository.findByQueja_Id(id);
    }

    @Override
    public Respuesta buscarRespuestasPorEmpresa(Long id) {
        return respuestaRepository.findByEmpresa_Id(id);
    }
}
