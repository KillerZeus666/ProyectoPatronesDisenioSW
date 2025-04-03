package com.proyecto.demo.controlador;

import com.proyecto.demo.entidad.Empresa;
import com.proyecto.demo.servicio.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/listar")
    public String listarEmpresas(Model model) {
        List<Empresa> empresas = empresaService.obtenerTodas();
        model.addAttribute("empresas", empresas);
        return "listaEmpresas";
    }

    @PostMapping("/guardar")
    public String guardarEmpresa(@ModelAttribute Empresa empresa) {
        empresaService.guardar(empresa);
        return "redirect:/empresa/listar";
    }

    @PostMapping("/eliminar")
    public String eliminarEmpresa(@RequestParam Long id) {
        empresaService.eliminar(id);
        return "redirect:/empresa/listar";
    }

    @PostMapping("/actualizarEntidadVigilante")
    public String actualizarEntidadVigilante(@RequestParam Long id, @RequestParam Long entidadId) {
        empresaService.actualizarEntidadVigilante(id, entidadId);
        return "redirect:/tipo_quejas";
    }
}
