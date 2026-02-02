package com.espe.edu.ec.ControlLectura.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "simulacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Simulacion {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "fecha_simulacion", nullable = false)
    private LocalDateTime fechaSimulacion;

    @Column(name = "capital_disponible", nullable = false, precision = 10, scale = 2)
    private BigDecimal capitalDisponible;

    @Column(name = "ganancia_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal gananciaTotal;

    @OneToMany(mappedBy = "simulacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SimulacionProducto> productos;
}
