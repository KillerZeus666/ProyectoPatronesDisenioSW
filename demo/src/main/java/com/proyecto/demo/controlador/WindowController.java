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
}
