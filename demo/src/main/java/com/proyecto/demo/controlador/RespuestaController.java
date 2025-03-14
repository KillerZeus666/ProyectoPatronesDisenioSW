package com.proyecto.demo.controlador;

import com.proyecto.demo.entidad.Respuesta;
import com.proyecto.demo.servicio.RespuestaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

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
