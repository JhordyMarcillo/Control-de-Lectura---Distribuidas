package com.espe.edu.ec.ControlLectura.service.serviceImpl;

import com.espe.edu.ec.ControlLectura.dtos.UsuarioDTO;
import com.espe.edu.ec.ControlLectura.entities.Usuario;
import com.espe.edu.ec.ControlLectura.repository.UsuarioRepository;
import com.espe.edu.ec.ControlLectura.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(UUID id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();

    }

    private UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setCapitalDisponible(usuario.getCapitalDisponible());
        return dto;
    }

}
