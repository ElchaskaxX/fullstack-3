package com.mediflow.demo.controller;

import com.mediflow.demo.model.ResultadoLaboratorio;
import com.mediflow.demo.service.LaboratorioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {

    private final LaboratorioService service;

    public LaboratorioController(LaboratorioService service) {
        this.service = service;
    }

    @PostMapping("/resultado")
    public String guardar(@RequestParam String pacienteId, @RequestParam String resultado) {
        service.guardarResultado(pacienteId, resultado);
        return "Resultado guardado";
    }

    @GetMapping("/resultado/{id}")
    public ResultadoLaboratorio obtener(@PathVariable String id) {
        return service.obtenerResultado(id);
    }
}