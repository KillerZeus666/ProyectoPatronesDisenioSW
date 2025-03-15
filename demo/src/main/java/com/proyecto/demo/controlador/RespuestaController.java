package com.proyecto.demo.controlador;

import com.proyecto.demo.entidad.Respuesta;
import com.proyecto.demo.servicio.RespuestaService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    // Mostrar formulario para responder una queja
    @GetMapping("/registrar")
    public String mostrarFormulario(@RequestParam Long idQueja, HttpSession session, Model model) {
        Long idEmpresa = (Long) session.getAttribute("empresaId");

        if (idEmpresa == null) {
            return "redirect:/portalUsuario";
        }

        model.addAttribute("idQueja", idQueja);
        model.addAttribute("idEmpresa", idEmpresa);
        return "respuestaEmpresa";
    }

    // Procesar el formulario y guardar en la base de datos
    @PostMapping("/registrar")
    public String registrarRespuesta(@RequestParam String descripcion,
                                     @RequestParam Long idEmpresa,
                                     @RequestParam Long idQueja) {
        respuestaService.registrarRespuesta(descripcion, idEmpresa, idQueja);
        return "redirect:/portalEmpresa"; // Redirigir después de guardar
    }


    // Endpoint para obtener una respuesta por ID
    @GetMapping("/{id}")
    public Respuesta obtenerRespuesta(@PathVariable Long id) {
        return respuestaService.buscarRespuesta(id);
    }

    // Endpoint para ver respuestas por ID de queja
    @GetMapping("/queja/{id}")
    public List<Respuesta> verRespuestasPorQueja(@PathVariable Long id) {
        return respuestaService.verRespuestasPorQueja(id);
    }

    // Endpoint para obtener respuestas por empresa
    @GetMapping("/empresa/{id}")
    public List<Respuesta> obtenerRespuestasPorEmpresa(@PathVariable Long id) {
        return respuestaService.buscarRespuestasPorEmpresa(id);
    }
    
  
}
