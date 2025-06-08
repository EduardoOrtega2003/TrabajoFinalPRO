package com.tuapp.notasapi.service;

import com.tuapp.notasapi.model.Usuario;
import com.tuapp.notasapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl extends AbstractCrudService<Usuario, Long> implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        super(repository);
        this.usuarioRepository = repository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        // Validaciones básicas
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (usuario.getPasswordHash() == null || usuario.getPasswordHash().trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }
        if (usuario.getPasswordHash().length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
        }

        // Verificar si el email ya existe
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        return super.save(usuario);
    }
}