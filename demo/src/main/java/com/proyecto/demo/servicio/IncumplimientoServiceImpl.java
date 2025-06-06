package com.proyecto.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.demo.entidad.Incumplimiento;
import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.repositorio.IncumplimientoRepository; 


import jakarta.transaction.Transactional;

@Service
public class IncumplimientoServiceImpl implements IncumplimientoService {
    
    @Autowired 
    IncumplimientoRepository incumplimientoRepository; 
    
    @Autowired
    private ProfesionalService profesionalService;

    @Override
    @Transactional
    public void onQuejaVencida(Queja queja) {
        Incumplimiento incumplimiento = new Incumplimiento();
        incumplimiento.setQueja(queja);
        incumplimiento.setEmpresa(queja.getEmpresa());
        incumplimiento.setDescripcion("Incumplimiento por vencimiento de queja #" + queja.getId() + ": " + queja.getDescripcion());

        incumplimientoRepository.save(incumplimiento); 

        // Asignar inmediatamente al profesional con menor carga
        profesionalService.asignarIncumplimiento(incumplimiento); 

        System.out.println("Incumplimiento creado y asignado: " + incumplimiento.getId());
    }

    @Override
    public List<Incumplimiento> obtenerTodosIncumplimientos() {
        return incumplimientoRepository.findAll();
    }

    @Override
    public List<Incumplimiento> verIncumplimientosPorEmpresa(Long empresaId) {
        List<Incumplimiento> incumplimientos = incumplimientoRepository.findByEmpresa_Id(empresaId);
        System.out.println("Incumplimientos encontrados para empresa " + empresaId + ": " + incumplimientos.size());
        return incumplimientos;
    }

    @Override
    public List<Incumplimiento> obtenerIncumplimientosPorProfesional(Long profesionalId) {
        return incumplimientoRepository.findByProfesionalAsignadoId(profesionalId);
    }
}
