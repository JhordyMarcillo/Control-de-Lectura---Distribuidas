package com.espe.edu.ec.ControlLectura.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "productos_financieros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoFinanciero {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false, name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(nullable = false, name = "porcentaje_retorno", precision = 5, scale = 2)
    private BigDecimal porcentajeRetorno;

    @Column(nullable = false)
    private Boolean activo;
}
