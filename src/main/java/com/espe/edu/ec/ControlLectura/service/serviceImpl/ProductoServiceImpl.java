package com.espe.edu.ec.ControlLectura.service.serviceImpl;

import com.espe.edu.ec.ControlLectura.dtos.ProductoDTO;
import com.espe.edu.ec.ControlLectura.entities.ProductoFinanciero;
import com.espe.edu.ec.ControlLectura.repository.ProductoRepository;
import com.espe.edu.ec.ControlLectura.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoFinanciero> obtenerProductosActivo() {
        return productoRepository.findByActivoTrue();
    }

    @Override
    public List<ProductoDTO> listarProductosActivos() {
        return productoRepository.findByActivoTrue()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    private ProductoDTO mapToDto(ProductoFinanciero producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getCosto());
        dto.setPorcentajeGanancia(producto.getPorcentajeRetorno());
        dto.setGananciaEsperada(null); // no aplica en listado
        return dto;
    }
}