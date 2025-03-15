package com.proyecto.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.servicio.QuejaService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/quejas")
public class QuejaController {

    @Autowired
    private QuejaService quejaService;

    @PostMapping("/registrar")
    public Queja registrarQueja(@RequestBody QuejaRequest quejaRequest) {
        return quejaService.registrarQueja(
                quejaRequest.getFecha(),
                quejaRequest.getTipo(),
                quejaRequest.getDescripcion(),
                quejaRequest.getIdServicio(),
                quejaRequest.getIdEmpresa(),
                quejaRequest.getIdUsuario()
        );
    }

    @GetMapping("/{id}")
    public Queja buscarQueja(@PathVariable Long id) {
        return quejaService.buscarQueja(id);
    }

    @GetMapping("/usuario/{cedula}")
    public List<Queja> verQuejasPorUsr(@PathVariable Long cedula) {
        return quejaService.verQuejasPorUsr(cedula);
    }
}
