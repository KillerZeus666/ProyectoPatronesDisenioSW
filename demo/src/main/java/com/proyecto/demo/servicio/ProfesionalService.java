package com.proyecto.demo.servicio;

import com.proyecto.demo.entidad.Incumplimiento;
import com.proyecto.demo.entidad.Profesional;

public interface ProfesionalService {
    public void asignarIncumplimiento(Incumplimiento incumplimiento);

    public void balancearCargaTrabajo();

    public void balancearAutomaticamente();
}
