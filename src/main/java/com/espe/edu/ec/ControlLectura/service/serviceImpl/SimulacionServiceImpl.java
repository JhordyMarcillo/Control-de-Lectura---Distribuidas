package com.espe.edu.ec.ControlLectura.service.serviceImpl;

import com.espe.edu.ec.ControlLectura.dtos.ProductoDTO;
import com.espe.edu.ec.ControlLectura.dtos.SimulacionRequestDTO;
import com.espe.edu.ec.ControlLectura.dtos.SimulacionResponseDTO;
import com.espe.edu.ec.ControlLectura.dtos.SimulacionResumenDTO;
import com.espe.edu.ec.ControlLectura.entities.ProductoFinanciero;
import com.espe.edu.ec.ControlLectura.entities.Simulacion;
import com.espe.edu.ec.ControlLectura.entities.SimulacionProducto;
import com.espe.edu.ec.ControlLectura.entities.Usuario;
import com.espe.edu.ec.ControlLectura.repository.ProductoRepository;
import com.espe.edu.ec.ControlLectura.repository.SimulacionRepository;
import com.espe.edu.ec.ControlLectura.repository.UsuarioRepository;
import com.espe.edu.ec.ControlLectura.service.SimulacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SimulacionServiceImpl implements SimulacionService {

    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;
    private final SimulacionRepository simulacionRepository;

    @Override
    public SimulacionResponseDTO simularInversion(SimulacionRequestDTO request) {

        BigDecimal capitalInvertido = BigDecimal.ZERO;
        BigDecimal gananciaTotal = BigDecimal.ZERO;

        List<ProductoDTO> resultados = new ArrayList<>();

        for (ProductoDTO producto : request.getProductos()) {

            BigDecimal ganancia = producto.getPrecio()
                    .multiply(producto.getPorcentajeGanancia())
                    .divide(BigDecimal.valueOf(100));

            capitalInvertido = capitalInvertido.add(producto.getPrecio());
            gananciaTotal = gananciaTotal.add(ganancia);

            resultados.add(
                    ProductoDTO.builder()
                            .nombre(producto.getNombre())
                            .precio(producto.getPrecio())
                            .porcentajeGanancia(producto.getPorcentajeGanancia())
                            .build()
            );
        }

        return SimulacionResponseDTO.builder()
                .gananciaTotal(gananciaTotal)
                .productos(resultados)
                .build();
    }


    @Override
    public List<SimulacionResponseDTO> obtenerSimulacionesPorUsuario(UUID usuarioId) {
        return simulacionRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(this::construirResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<SimulacionResumenDTO> listarSimulacionesPorUsuario(UUID usuarioId) {
        return simulacionRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(this::mapToResumenDto)
                .toList();
    }

    private SimulacionResponseDTO construirResponse(Simulacion simulacion) {

        List<ProductoDTO> productos = simulacion.getProductos().stream()
                .map(sp -> new ProductoDTO(
                        sp.getProducto().getNombre(),
                        sp.getCosto(),
                        sp.getPorcentajeRetorno(),
                        sp.getGananciaEstimada()
                ))
                .toList();

        return SimulacionResponseDTO.builder()
                .fechaSimulacion(simulacion.getFechaSimulacion())
                .capitalDisponible(simulacion.getCapitalDisponible())
                .gananciaTotal(simulacion.getGananciaTotal())
                .productos(productos)
                .build();
    }

    private SimulacionResumenDTO mapToResumenDto(Simulacion simulacion) {

        SimulacionResumenDTO dto = new SimulacionResumenDTO();
        dto.setId(simulacion.getId());
        dto.setUsuarioId(simulacion.getUsuario().getId());
        dto.setFechaSimulacion(simulacion.getFechaSimulacion());
        dto.setCapitalDisponible(simulacion.getCapitalDisponible());
        dto.setGananciaTotal(simulacion.getGananciaTotal());

        int cantidadProductos = simulacion.getProductos() != null
                ? simulacion.getProductos().size()
                : 0;
        dto.setCantidadProductos(cantidadProductos);

        if (simulacion.getCapitalDisponible().compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal retorno = simulacion.getGananciaTotal()
                    .divide(simulacion.getCapitalDisponible(), 4, BigDecimal.ROUND_HALF_UP)
                    .multiply(BigDecimal.valueOf(100));
            dto.setRetornoPorcentaje(retorno);
        } else {
            dto.setRetornoPorcentaje(BigDecimal.ZERO);
        }

        return dto;
    }
}