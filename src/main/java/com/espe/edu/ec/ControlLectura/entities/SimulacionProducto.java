package com.espe.edu.ec.ControlLectura.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "simulacion_producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimulacionProducto {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "simulacion_id")
    private Simulacion simulacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "producto_id")
    private ProductoFinanciero producto;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(name = "porcentaje_retorno", nullable = false, precision = 5, scale = 2)
    private BigDecimal porcentajeRetorno;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal riesgo;

    @Column(name = "ganancia_estimada", nullable = false, precision = 10, scale = 2)
    private BigDecimal gananciaEstimada;
}
