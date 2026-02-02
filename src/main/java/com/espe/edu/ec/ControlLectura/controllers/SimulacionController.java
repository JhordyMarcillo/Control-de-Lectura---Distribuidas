package com.espe.edu.ec.ControlLectura.controllers;

import com.espe.edu.ec.ControlLectura.dtos.SimulacionRequestDTO;
import com.espe.edu.ec.ControlLectura.dtos.SimulacionResponseDTO;
import com.espe.edu.ec.ControlLectura.dtos.SimulacionResumenDTO;
import com.espe.edu.ec.ControlLectura.service.SimulacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/simulaciones")
@RequiredArgsConstructor
public class SimulacionController {
    private final SimulacionService simulacionService;

    @PostMapping
    public SimulacionResponseDTO simular(@RequestBody SimulacionRequestDTO request) {
        return simulacionService.simularInversion(request);
    }

    @GetMapping("/{usuarioId}")
    public List<SimulacionResumenDTO> listarPorUsuario(
            @PathVariable UUID usuarioId
    ) {
        return simulacionService.listarSimulacionesPorUsuario(usuarioId);
    }
}
