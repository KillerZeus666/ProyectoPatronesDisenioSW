package com.proyecto.demo.controlador;

import com.proyecto.demo.entidad.Servicio;
import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.servicio.ServicioService;
import com.proyecto.demo.servicio.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private EmpresaService empresaService;

    public String mostrarConfiguracion(Model model) {
        List<Servicio> servicios = servicioService.obtenerTodos();
        List<Empresa> empresas = empresaService.obtenerTodas();
        model.addAttribute("servicios", servicios);
        model.addAttribute("empresas", empresas);
        return "configuracionTipoQueja";
    }

    @PostMapping("/actualizarEmpresaServicio")
    public String actualizarEmpresaServicio(@RequestParam Long servicioId, @RequestParam Long empresaId) {
        servicioService.actualizarEmpresa(servicioId, empresaId);
        return "redirect:/configuracionTipoQueja";
    }
}