package com.proyecto.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.demo.entidad.Incumplimiento;
import com.proyecto.demo.entidad.Profesional;
import com.proyecto.demo.servicio.IncumplimientoService;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/Profesional")
public class ProfesionalController {

    @Autowired
    IncumplimientoService incumplimientoService; 
    
    /*@GetMapping("/info")
    public String obtenerInfo() {
        return "Información del Profesional";
    }*/

    @GetMapping("/casos/{id}")
    public String verCasosAsignados(@PathVariable("id") Long profesionalId, Model model) {
        List<Incumplimiento> incumplimientos = incumplimientoService.obtenerIncumplimientosPorProfesional(profesionalId);
        model.addAttribute("incumplimientos", incumplimientos);
        return "portalProfesionalCasos"; 
    }

}
