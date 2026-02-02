package com.espe.edu.ec.ControlLectura.repository;

import com.espe.edu.ec.ControlLectura.entities.ProductoFinanciero;
import com.espe.edu.ec.ControlLectura.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductoRepository extends JpaRepository<ProductoFinanciero, UUID> {
    List<ProductoFinanciero> findByActivoTrue();
}
