package com.espe.edu.ec.ControlLectura.controllers;

import com.espe.edu.ec.ControlLectura.dtos.ProductoDTO;
import com.espe.edu.ec.ControlLectura.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @GetMapping
    public List<ProductoDTO> listarProductos() {
        return productoService.listarProductosActivos();
    }
}
