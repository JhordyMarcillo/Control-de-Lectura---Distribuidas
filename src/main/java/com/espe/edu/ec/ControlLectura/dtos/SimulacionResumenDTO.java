package com.espe.edu.ec.ControlLectura.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SimulacionResumenDTO {

    private UUID id;

    @JsonProperty("usuario_id")
    private UUID usuarioId;

    @JsonProperty("fecha_simulacion")
    private LocalDateTime fechaSimulacion;

    @JsonProperty("capital_disponible")
    private BigDecimal capitalDisponible;

    @JsonProperty("ganancia_total")
    private BigDecimal gananciaTotal;

    @JsonProperty("cantidad_productos")
    private Integer cantidadProductos;

    @JsonProperty("retorno_porcentaje")
    private BigDecimal retornoPorcentaje;
}
