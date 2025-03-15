package com.proyecto.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
>>>>>>> 527be6eb40cf5edafaee360f563d843afcfb860b
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

    // Endpoint para listar todas las quejas de una empresa con su id y mostrarlas en una vista HTML
    @GetMapping("/{empresaId}")
    public String obtenerQuejasPorEmpresa(@PathVariable Long empresaId, Model model) {
        List<Queja> quejas = quejaService.verQuejasPorEmpresa(empresaId);
        model.addAttribute("quejas", quejas);
        return "vistaQuejas"; // Nombre del archivo HTML (vistaQuejas.html)
    }
}
