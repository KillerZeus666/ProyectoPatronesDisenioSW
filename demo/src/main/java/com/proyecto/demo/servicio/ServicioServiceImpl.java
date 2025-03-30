package com.proyecto.demo.servicio;

import com.proyecto.demo.entidad.Servicio;
import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.repositorio.ServicioRepository;
import com.proyecto.demo.repositorio.EmpresaRepository;
import com.proyecto.demo.servicio.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<Servicio> obtenerTodos() {
        return servicioRepository.findAll();
    }

    @Override
    public void actualizarEmpresa(Long servicioId, Long empresaId) {
        Optional<Servicio> servicioOpt = servicioRepository.findById(servicioId);
        Optional<Empresa> empresaOpt = empresaRepository.findById(empresaId);

        if (servicioOpt.isPresent() && empresaOpt.isPresent()) {
            Servicio servicio = servicioOpt.get();
            servicio.setEmpresa(empresaOpt.get());
            servicioRepository.save(servicio);
        }
    }
}
