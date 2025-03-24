package com.proyecto.demo.controlador;

import com.proyecto.demo.entidad.TipoQueja;
import com.proyecto.demo.servicio.TipoQuejaService;

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

    @GetMapping
    public String mostrarConfiguracion(Model model) {
        List<TipoQueja> tiposQueja = tipoQuejaService.obtenerTodosLosTiposQueja();
        model.addAttribute("tiposQueja", tiposQueja);
        return "configuracionTipoQueja";
    }

    @PostMapping("/actualizar")
    public String actualizarTiempoAtencion(@RequestParam Long id, @RequestParam int tiempoAtencion) {
        tipoQuejaService.actualizarTiempoAtencion(id, tiempoAtencion);
        return "redirect:/tipo_quejas";
    }

}