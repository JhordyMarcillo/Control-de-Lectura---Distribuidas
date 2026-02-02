package com.espe.edu.ec.ControlLectura.service;

import com.espe.edu.ec.ControlLectura.dtos.UsuarioDTO;
import com.espe.edu.ec.ControlLectura.entities.Usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {
    List<Usuario> obtenerTodos();

    Usuario obtenerPorId(UUID id);
    List<UsuarioDTO> listarUsuarios();
}
