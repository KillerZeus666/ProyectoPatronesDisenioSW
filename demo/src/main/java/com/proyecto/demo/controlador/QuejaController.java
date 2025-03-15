package com.proyecto.demo.controlador;

import com.proyecto.demo.dto.QuejaRequest;
import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.entidad.Usuario;
import com.proyecto.demo.servicio.EmpresaService;
import com.proyecto.demo.servicio.QuejaService;
import com.proyecto.demo.servicio.ServicioService;
import com.proyecto.demo.servicio.TipoQuejaService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/quejas")
public class QuejaController {

    @Autowired
    private QuejaService quejaService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private TipoQuejaService tipoQuejaService;

    @GetMapping("/formulario")
    public String mostrarFormularioRegistroQueja(Model model, HttpSession session) {
        Usuario usuarioLogueado = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuarioLogueado == null) {
            return "redirect:/portalUsuario";
        }
        model.addAttribute("quejaRequest", new QuejaRequest());
        model.addAttribute("tiposQueja", tipoQuejaService.obtenerTodosLosTiposQueja());
        model.addAttribute("empresas", empresaService.obtenerTodasLasEmpresas());
        model.addAttribute("servicios", servicioService.obtenerTodosLosServicios());
        return "registrarQueja";
    } 

    // Endpoint para registrar una queja usando x-www-form-urlencoded
    @PostMapping("/registrar")
    public String registrarQueja(@ModelAttribute QuejaRequest quejaRequest, Model model, HttpSession session) {
        // Obtener el usuario de la sesión
        Usuario usuarioLogueado = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuarioLogueado == null) {
            return "redirect:/portalUsuario"; // Redirige si no hay usuario autenticado
        }
        // Asigna el idUsuario obtenido de la sesión al objeto request
        quejaRequest.setIdUsuario(usuarioLogueado.getId());
        
        // Llama al servicio para registrar la queja
        quejaService.registrarQueja(
            quejaRequest.getFecha(),
            quejaRequest.getTipo(),
            quejaRequest.getDescripcion(),
            quejaRequest.getIdServicio(),
            quejaRequest.getIdEmpresa(),
            quejaRequest.getIdUsuario()
        );
        // Redirige a la pantalla de opciones del ciudadano
        return "redirect:/opcionesCiudadano";
    }

    // Endpoint para buscar una queja por ID, devolviendo JSON
    @GetMapping("/detalle/{id}")
    @ResponseBody
    public Queja buscarQueja(@PathVariable Long id) {
        return quejaService.buscarQueja(id);
    }

    // Endpoint para ver quejas por cédula de usuario, devolviendo JSON
    @GetMapping("/usuario/{cedula}")
    public String verQuejasPorUsr(@PathVariable Long cedula, Model model) {
        List<Queja> quejas = quejaService.verQuejasPorUsr(cedula);
        model.addAttribute("quejas", quejas);
        return "vistaQuejasCiudadano";
    }

    // Endpoint para listar todas las quejas de una empresa y mostrarlas en una vista HTML
    @GetMapping("/empresa/{empresaId}")
    public String obtenerQuejasPorEmpresa(@PathVariable Long empresaId, Model model) {
        List<Queja> quejas = quejaService.verQuejasPorEmpresa(empresaId);
        model.addAttribute("quejas", quejas);
        return "vistaQuejasEmpresa"; // Nombre de la plantilla HTML (vistaQuejas.html)
    }
}
