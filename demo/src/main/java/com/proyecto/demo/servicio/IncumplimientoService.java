package com.proyecto.demo.servicio;

import java.util.List;

import com.proyecto.demo.entidad.Incumplimiento;
import com.proyecto.demo.entidad.Queja;

public interface IncumplimientoService {
    void onQuejaVencida(Queja queja);

    // Ver todos los incumplimientos
    List<Incumplimiento> obtenerTodosIncumplimientos();
    
    // Ver incumplimiento por empresa 
    List<Incumplimiento> verIncumplimientosPorEmpresa(Long empresaId);

    //Ver incumplimientos por profesional
    List<Incumplimiento> obtenerIncumplimientosPorProfesional(Long profesionalId);
}
