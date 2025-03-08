package com.proyecto.demo.controlador;

import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.servicio.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quejas")
public class QuejaController {

    @Autowired
    private QuejaService quejaService;

    // Endpoint para registrar una queja
    @PostMapping("/registrar")
    public Queja registrarQueja(@RequestBody QuejaRequest request) {
        return quejaService.registrarQueja(
            request.getFecha(),
            request.getTipo(),
            request.getDescripcion(),
            request.getIdServicio(),
            request.getIdEmpresa(),
            request.getIdUsuario()
        );
    }    
    

    // Endpoint para buscar una queja por ID
    @GetMapping("/{id}")
    public Queja buscarQueja(@PathVariable Long id) {
        return quejaService.buscarQueja(id);
    }

    // Endpoint para ver quejas por cédula de usuario
    @GetMapping("/usuario/{cedula}")
    public List<Queja> verQuejasPorUsr(@PathVariable Long cedula) {
        return quejaService.verQuejasPorUsr(cedula);
    }
}
