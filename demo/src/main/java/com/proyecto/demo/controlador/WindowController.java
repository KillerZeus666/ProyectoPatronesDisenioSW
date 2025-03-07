package com.proyecto.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.demo.entidad.Usuario;
import com.proyecto.demo.servicio.UsuarioService;

import jakarta.servlet.http.HttpSession;


@Controller
public class WindowController {

    @Autowired
    private UsuarioService usuarioService; 

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


    @PostMapping("/inicio_sesion")
    public String iniciarSesion(@RequestParam("correo") String correo,
                                @RequestParam("contraseña") String contraseña,
                                Model model, HttpSession session ) {
        Usuario usuario = usuarioService.validarUsuario(correo, contraseña);
    
        if (usuario == null) { 
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "portalUsuario"; 
        }
    
        // Guardar la cédula en la sesión
        session.setAttribute("cedula", usuario.getCedula());
        return "portalUsuario"; 
    }
    
    
}
