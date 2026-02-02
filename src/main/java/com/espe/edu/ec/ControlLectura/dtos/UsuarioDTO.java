package com.espe.edu.ec.ControlLectura.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class UsuarioDTO {

    private UUID id;
    private String nombre;
    private String email;

    @JsonProperty("capital_disponible")
    private BigDecimal capitalDisponible;
}
