package com.espe.edu.ec.ControlLectura.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class SimulacionRequestDTO {
    @JsonProperty("usuario_id")
    private UUID usuarioId;

    @JsonProperty("capital_disponible")
    private BigDecimal capitalDisponible;

    private List<ProductoDTO> productos;
}
