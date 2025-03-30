package com.proyecto.demo.controlador;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.Incumplimiento;
import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.repositorio.EmpresaRepository;
import com.proyecto.demo.servicio.IncumplimientoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/incumplimiento")
public class IncumplimientoController {

    @Autowired
    private IncumplimientoService incumplimientoService;

    @Autowired
    private EmpresaRepository empresaRepository;
    
    /*@GetMapping("/info")
    public String obtenerInfo() {
        return "Información del Incumplimiento";
    }*/

        //Metodo para mostrar todas las quejas 
        @GetMapping("/all")
        public String listarTodosIncumplimientos(Model model) {
            List<Incumplimiento> listaIncumplimiento = incumplimientoService.obtenerTodosIncumplimientos(); // Método en el servicio
        
            // Imprimir en consola cada incumplimiento
            listaIncumplimiento.forEach(inc -> System.out.println("Queja: " + inc.toString()));
        
            model.addAttribute("incumplimientos", listaIncumplimiento);
            return "listaIncumplimiento";
        }
        

    // Endpoint para listar todas las quejas de una empresa y mostrarlas en una vista HTML
    @GetMapping("/empresa/{empresaId}")
    public String obtenerIncumplimientosPorEmpresa(@PathVariable Long empresaId, Model model) {
        Empresa empresa = empresaRepository.findById(empresaId).orElse(null);
        List<Incumplimiento> incumplimientos = incumplimientoService.verIncumplimientosPorEmpresa(empresaId);
        model.addAttribute("incumplimientos", incumplimientos);
        model.addAttribute("empresa", empresa);

        return "vistaIncumplimientoPorEmpresa";
    }
}