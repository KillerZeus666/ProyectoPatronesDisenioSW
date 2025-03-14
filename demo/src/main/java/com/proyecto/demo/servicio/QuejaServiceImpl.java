package com.proyecto.demo.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.entidad.Servicio;
import com.proyecto.demo.entidad.Usuario;
import com.proyecto.demo.repositorio.EmpresaRepository;
import com.proyecto.demo.repositorio.QuejaRepository;
import com.proyecto.demo.repositorio.ServicioRepository;
import com.proyecto.demo.repositorio.UsuarioRepository;

import jakarta.annotation.PostConstruct;

@Service
public class QuejaServiceImpl implements QuejaService {

    @Autowired
    private QuejaRepository quejaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; // Agregado para validar el usuario

    @Autowired
    private EmpresaRepository empresaRepository; // Agregado para validar la empresa

    @PostConstruct
    public void init() {
        System.out.println("QuejaServiceImpl ha sido registrado por Spring!");
    }

    @Override
    public Queja registrarQueja(Date fecha, String tipo, String descripcion, Long idServicio, Long idEmpresa,Long idUsuario) {
        Servicio servicio = servicioRepository.findById(idServicio)
                .orElseThrow(() -> new IllegalArgumentException("El servicio especificado no existe"));

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("El usuario especificado no existe"));
        
        Empresa empresa = empresaRepository.findById(idEmpresa)
                .orElseThrow(() -> new IllegalArgumentException("La empresa especificada no existe"));

        if (fecha == null) {
            fecha = new Date(); // Asigna la fecha actual si no se envía
        }

        Queja nuevaQueja = new Queja(fecha, tipo, descripcion, servicio, empresa, usuario);
        return quejaRepository.save(nuevaQueja);
    }

    @Override
    public Queja buscarQueja(Long id) {
        return quejaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Queja> verQuejasPorUsr(Long cedula) {
        return quejaRepository.findByUsuario_Cedula(cedula);
    }

    public List<Queja> verQuejasPorEmpresa(Long empresaId) {
        List<Queja> quejas = quejaRepository.findByEmpresa_Id(empresaId);
        System.out.println("Quejas encontradas para empresa " + empresaId + ": " + quejas.size());
        return quejas;
    }
    
}
