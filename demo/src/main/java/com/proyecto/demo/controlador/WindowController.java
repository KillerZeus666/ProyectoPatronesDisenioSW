package com.proyecto.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WindowController {
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
}
