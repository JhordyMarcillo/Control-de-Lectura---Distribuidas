package com.espe.edu.ec.ControlLectura.service;

import com.espe.edu.ec.ControlLectura.dtos.ProductoDTO;
import com.espe.edu.ec.ControlLectura.entities.ProductoFinanciero;
import com.espe.edu.ec.ControlLectura.entities.Usuario;

import java.util.List;

public interface ProductoService {
    List<ProductoFinanciero> obtenerProductosActivo();
    List<ProductoDTO> listarProductosActivos();
}
