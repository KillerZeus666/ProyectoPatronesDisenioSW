package com.proyecto.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.entidad.EntidadVigilante;
import com.proyecto.demo.entidad.Queja;
import com.proyecto.demo.entidad.Usuario;
import com.proyecto.demo.servicio.QuejaService;
import com.proyecto.demo.servicio.UsuarioService;
import com.proyecto.demo.servicio.EmpresaService;
import com.proyecto.demo.servicio.EntidadVigilanteService;


import jakarta.servlet.http.HttpSession;


@Controller
public class WindowController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private QuejaService quejaService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EntidadVigilanteService entidadService;

    @GetMapping("/index")
    public String mostrarPaginaIndex() {
        return "index";
    }

    @GetMapping("/servicio")
    public String mostrarPaginaServicio() {
        return "servicio";
    }

    @GetMapping("/portalEmpresa")
    public String mostrarPortalEmpresa() {
        return "portalEmpresa";
    }
    @GetMapping("/portalUsuario")
    public String mostrarPortalUsuario() {
        return "portalUsuario";
    }
    @GetMapping("/portalAdmin")
    public String mostrarPortalAdmin() {
        return "portalAdministrador";
    }

    @GetMapping("/portalAdministrador")
    public String mostrarPortalAdministrador() {
        return "portalAdministrador";
    }

    @PostMapping("/inicio_sesion")
    public String iniciarSesion(@RequestParam("correo") String correo,
                                @RequestParam("contraseña") String contraseña,
                                Model model, HttpSession session) {
        Usuario usuario = usuarioService.validarUsuario(correo, contraseña);
        Empresa empresa = empresaService.validarEmpresa(correo, contraseña);
        EntidadVigilante entidadVigilante = entidadService.validarEntidad(correo, contraseña);
    
        // Caso 1: Ningún usuario, empresa ni entidad coinciden
        if (usuario == null && empresa == null && entidadVigilante == null) {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "portalUsuario";
        }
    
        // Caso 2: Inicio de sesión de empresa
        if (empresa != null) {
            session.setAttribute("empresaId", empresa.getId());
            session.setAttribute("empresaNombre", empresa.getNombre());
            System.out.println("Empresa guardada en sesión: " + empresa.getNombre());
            return "redirect:/portalEmpresa";
        }
    
        // Caso 3: Inicio de sesión de entidad vigilante
        if (entidadVigilante != null) {
            session.setAttribute("entidadId", entidadVigilante.getId());
            session.setAttribute("entidadNombre", entidadVigilante.getNombre());
            System.out.println("Entidad Vigilante guardada en sesión: " + entidadVigilante.getNombre());
            return "redirect:/portalAdministrador";
        }
    
        // Caso 4: Inicio de sesión de usuario
        session.setAttribute("usuarioLogueado", usuario);
        return "redirect:/opcionesCiudadano";
    }
    

    @GetMapping("/opcionesCiudadano")
    public String mostrarOpcionesCiudadano(Model model, HttpSession session) {
        // Suponiendo que el usuario autenticado está almacenado en la sesión
        Usuario usuarioLogueado = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuarioLogueado == null) {
            return "redirect:/inicio_sesion"; // O la ruta de login
        }
        model.addAttribute("usuario", usuarioLogueado);
        return "opcionesCiudadano"; // Nombre de la plantilla Thymeleaf
    }

    @GetMapping("/quejas/registrar")
    public String mostrarFormularioRegistroQueja(Model model, HttpSession session) {
        Usuario usuarioLogueado = (Usuario) session.getAttribute("usuarioLogueado");
        if (usuarioLogueado == null) {
            return "redirect:/inicio_sesion"; // Redirige al login si no hay usuario
        }
        model.addAttribute("quejaRequest", new QuejaRequest());
        return "registrarQueja"; // Asegúrate de que exista registrarQueja.html
    }
}
