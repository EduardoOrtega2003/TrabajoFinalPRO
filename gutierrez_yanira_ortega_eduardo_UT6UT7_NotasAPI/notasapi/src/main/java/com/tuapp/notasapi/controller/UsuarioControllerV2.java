package com.tuapp.notasapi.controller;

import com.tuapp.notasapi.dto.UsuarioDTO;
import com.tuapp.notasapi.model.Usuario;
import com.tuapp.notasapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v2")
public class UsuarioControllerV2 {

    private final UsuarioService usuarioService;

    public UsuarioControllerV2(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/sign-in")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Usuario> signIn(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario no puede ser nulo");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPasswordHash(usuarioDTO.getPassword());
        
        try {
            Usuario savedUsuario = usuarioService.save(usuario);
            return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al crear el usuario: " + e.getMessage());
        }
    }
} 