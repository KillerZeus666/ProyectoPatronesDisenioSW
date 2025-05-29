package com.proyecto.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.EntidadVigilante;
import com.proyecto.demo.repositorio.EmpresaRepository;
import com.proyecto.demo.repositorio.EntidadVigilanteRepository;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    EntidadVigilanteRepository entidadVigilanteRepository;

    @Override
    public List<Empresa> obtenerTodas() {
        return empresaRepository.findAllOrderedById();
    }

    @Override
    public Optional<Empresa> obtenerPorId(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void eliminar(Long id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public Empresa validarEmpresa(String correo, String contraseña) {
        return empresaRepository.findByNombreAndContraseña(correo, contraseña);
    }

    @Override
    public void actualizarEntidadVigilante(Long empresaId, Long entidadId) {
        Optional<Empresa> empresaOpt = empresaRepository.findById(empresaId);
        Optional<EntidadVigilante> entidadOpt = entidadVigilanteRepository.findById(entidadId);

        if (empresaOpt.isPresent() && entidadOpt.isPresent()) {
            Empresa empresa = empresaOpt.get();
            empresa.setEntidadVigilante(entidadOpt.get());
            empresaRepository.save(empresa);
        }
    }

    @Override
    public void actualizarEntidadVigilanteMultiple(List<Long> empresaIds, Long entidadId) {
        Optional<EntidadVigilante> entidadOpt = entidadVigilanteRepository.findById(entidadId);
        if (entidadOpt.isPresent()) {
            EntidadVigilante entidad = entidadOpt.get();
            empresaIds.forEach(empresaId -> {
                Optional<Empresa> empresaOpt = empresaRepository.findById(empresaId);
                empresaOpt.ifPresent(empresa -> {
                    empresa.setEntidadVigilante(entidad);
                    empresaRepository.save(empresa);
                });
            });
        }
    }
}
