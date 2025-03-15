package com.proyecto.demo.servicio;

import com.proyecto.demo.entidad.Incumplimiento;
import com.proyecto.demo.entidad.Queja;

public interface IncumplimientoService {
    void onQuejaVencida(Queja queja);
}
