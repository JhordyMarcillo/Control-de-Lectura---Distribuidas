package com.espe.edu.ec.ControlLectura.repository;

import com.espe.edu.ec.ControlLectura.entities.SimulacionProducto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SimulacionProductoRepository extends JpaRepository<SimulacionProducto, UUID> {
    List<SimulacionProducto> findBySimulacionId(UUID simulacionId);
}
