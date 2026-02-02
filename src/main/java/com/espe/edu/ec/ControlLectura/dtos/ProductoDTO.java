package com.espe.edu.ec.ControlLectura.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {

    private String nombre;
    private BigDecimal precio;

    @JsonProperty("porcentaje_ganancia")
    private BigDecimal porcentajeGanancia;

    @JsonProperty("ganancia_esperada")
    private BigDecimal gananciaEsperada;
}
