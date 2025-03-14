package com.proyecto.demo.servicio;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.entidad.Respuesta;
import com.proyecto.demo.repositorio.EmpresaRepository;
import com.proyecto.demo.repositorio.RespuestaRepository;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private QuejaService quejaService;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    @Transactional
    public Respuesta registrarRespuesta(String descripcion, Long idEmpresa, Long idQueja) {
        Queja queja = quejaService.buscarQueja(idQueja);
        Empresa empresa = empresaRepository.findById(idEmpresa).orElse(null);
        
        if (queja == null) {
            throw new IllegalArgumentException("La queja especificada no existe");
        }
        if (empresa == null) {
            throw new IllegalArgumentException("La empresa especificada no existe");
        }
        
        Date fechaRespuesta = new Date();
        Respuesta nuevaRespuesta = new Respuesta(fechaRespuesta, descripcion, empresa, queja);
        return respuestaRepository.save(nuevaRespuesta);
    }

    @Override
    public Respuesta buscarRespuesta(Long id) {
        return respuestaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Respuesta> verRespuestasPorQueja(Long idQueja) {
        return respuestaRepository.findByQueja_Id(idQueja);
    }

    @Override
    public List<Respuesta> buscarRespuestasPorEmpresa(Long idEmpresa) {
        return respuestaRepository.findByEmpresa_Id(idEmpresa);
    }
}
