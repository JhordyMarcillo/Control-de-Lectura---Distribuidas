package com.espe.edu.ec.ControlLectura.service;

import com.espe.edu.ec.ControlLectura.dtos.SimulacionRequestDTO;
import com.espe.edu.ec.ControlLectura.dtos.SimulacionResponseDTO;
import com.espe.edu.ec.ControlLectura.dtos.SimulacionResumenDTO;
import com.espe.edu.ec.ControlLectura.entities.SimulacionProducto;

import java.util.List;
import java.util.UUID;

public interface SimulacionService {

    SimulacionResponseDTO simularInversion(SimulacionRequestDTO request);
    List<SimulacionResponseDTO> obtenerSimulacionesPorUsuario(UUID usuarioId);
    List<SimulacionResumenDTO> listarSimulacionesPorUsuario(UUID usuarioId);
}
