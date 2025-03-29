package com.proyecto.demo.servicio;

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
}
