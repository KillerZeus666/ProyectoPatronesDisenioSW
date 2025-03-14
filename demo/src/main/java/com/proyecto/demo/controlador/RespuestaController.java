package com.proyecto.demo.controlador;

import com.proyecto.demo.entidad.Respuesta;
import com.proyecto.demo.servicio.RespuestaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    // Mostrar la vista para generar la respuesta con los datos de la queja y la empresa
    @GetMapping("/registrar")
    public String mostrarFormulario(@RequestParam Long idQueja, @RequestParam Long idEmpresa, Model model) {
        model.addAttribute("idQueja", idQueja);
        model.addAttribute("idEmpresa", idEmpresa);
        return "respuestaEmpresa";  // Redirige a la vista respuestaempresa.html
    }

    // Endpoint para registrar una respuesta
    @PostMapping("/registrar")
    public Respuesta registrarRespuesta(@RequestParam Long id, 
                                        @RequestParam String descripcion,
                                        @RequestParam Long idEmpresa, 
                                        @RequestParam Long idQueja) {
        return respuestaService.registrarRespuesta( descripcion, idEmpresa, idQueja);
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
