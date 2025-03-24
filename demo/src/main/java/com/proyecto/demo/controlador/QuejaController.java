package com.proyecto.demo.controlador;

import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.entidad.Usuario;
import com.proyecto.demo.servicio.QuejaService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/quejas")
public class QuejaController {

    @Autowired
    private QuejaService quejaService;

    // Endpoint para registrar una queja
    @PostMapping("/registrar")
    public String registrarQueja(@ModelAttribute QuejaRequest request, Model model, HttpSession session) {
        // Obtener el usuario de la sesión
        Usuario usuarioLogueado = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuarioLogueado == null) {
            return "redirect:/inicio_sesion"; // Redirige si no hay usuario autenticado
        }
        // Asigna el idUsuario obtenido de la sesión al objeto request
        request.setIdUsuario(usuarioLogueado.getId());
        
        // Llama al servicio para registrar la queja
        Queja nuevaQueja = quejaService.registrarQueja(
            request.getFecha(),
            request.getTipo(),
            request.getDescripcion(),
            request.getIdServicio(),
            request.getIdEmpresa(),
            request.getIdUsuario()
        );
        return "redirect:/opcionesCiudadano"; // Redirige a la vista de opciones, por ejemplo
    }  
    

    // Endpoint para buscar una queja por ID
    @GetMapping("/id/{id}")
    public Queja buscarQueja(@PathVariable Long id) {
        return quejaService.buscarQueja(id);
    }

    // Endpoint para listar todas las quejas    
    @GetMapping("/usuario/{cedula}")
    public String verQuejasPorUsuario(@PathVariable Long cedula, Model model) {
        List<Queja> quejas = quejaService.verQuejasPorUsr(cedula);
        model.addAttribute("quejas", quejas);
        return "QuejasCiudadano";  // Nombre de esta plantilla (misQuejas.html)
    }

    // Endpoint para listar todas las quejas de una empresa con su id y mostrarlas en una vista HTML
    @GetMapping("/{empresaId}")
    public String obtenerQuejasPorEmpresa(@PathVariable Long empresaId, Model model) {
        List<Queja> quejas = quejaService.verQuejasPorEmpresa(empresaId);
        model.addAttribute("quejas", quejas);
        return "vistaQuejas"; // Nombre del archivo HTML (vistaQuejas.html)
    }
    //Metodo para mostrar todas las quejas 
    @GetMapping("/todas")
    public String listarTodasLasQuejas(Model model) {
        List<Queja> listaQuejas = quejaService.obtenerTodasLasQuejas(); // Método en el servicio
        model.addAttribute("quejas", listaQuejas);
        return "listaQuejas"; // Asegúrate de que el nombre coincida con la vista HTML
    }
}
