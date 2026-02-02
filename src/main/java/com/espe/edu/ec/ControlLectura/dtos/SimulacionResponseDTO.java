package com.espe.edu.ec.ControlLectura.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class SimulacionResponseDTO {

    private UUID id;

    @JsonProperty("usuario_id")
    private UUID usuarioId;

    private UUID simulacionId;


    @JsonProperty("fecha_simulacion")
    private LocalDateTime fechaSimulacion;

    @JsonProperty("capital_disponible")
    private BigDecimal capitalDisponible;


    private BigDecimal gananciaTotal;
    private List<ProductoDTO> productos;
}