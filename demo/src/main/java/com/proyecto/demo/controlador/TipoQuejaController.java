package com.proyecto.demo.controlador;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.Servicio;
import com.proyecto.demo.entidad.TipoQueja;
import com.proyecto.demo.servicio.TipoQuejaService;
import com.proyecto.demo.servicio.ServicioService;
import com.proyecto.demo.servicio.EmpresaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tipo_quejas")
public class TipoQuejaController {

    @Autowired
    private TipoQuejaService tipoQuejaService;

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public String mostrarConfiguracion(Model model) {
        List<TipoQueja> tiposQueja = tipoQuejaService.obtenerTodosLosTiposQueja();
        List<Servicio> servicios = servicioService.obtenerTodos();
        List<Empresa> empresas = empresaService.obtenerTodas();
        model.addAttribute("servicios", servicios);
        model.addAttribute("empresas", empresas);
        model.addAttribute("tiposQueja", tiposQueja);
        return "configuracionTipoQueja";
    }

    public String mostrarConfiguracionServicios(Model model) {

        return "configuracionTipoQueja";
    }

    @PostMapping("/actualizar")
    public String actualizarTiempoAtencion(@RequestParam Long id, @RequestParam int tiempoAtencion) {
        tipoQuejaService.actualizarTiempoAtencion(id, tiempoAtencion);
        return "redirect:/tipo_quejas";
    }

}
