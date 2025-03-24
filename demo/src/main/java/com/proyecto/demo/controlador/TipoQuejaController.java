package com.proyecto.demo.controlador;

import com.proyecto.demo.servicio.TipoQuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tipo_quejas")
public class TipoQuejaController {

    @Autowired
    private TipoQuejaService tipoQuejaService;

}
