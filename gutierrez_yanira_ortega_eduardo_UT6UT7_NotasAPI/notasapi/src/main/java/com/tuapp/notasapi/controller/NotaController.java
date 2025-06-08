package com.tuapp.notasapi.controller;

import com.tuapp.notasapi.model.Nota;
import com.tuapp.notasapi.model.Usuario;
import com.tuapp.notasapi.service.NotaService;
import com.tuapp.notasapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notas")
public class NotaController {

    private final NotaService notaService;
    private final UsuarioService usuarioService;

    public NotaController(NotaService notaService, UsuarioService usuarioService) {
        this.notaService = notaService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Nota> getAllNotas(
            @RequestParam(required = false) Long usuarioId,
            @RequestParam(defaultValue = "asc") String order) {
        if (usuarioId != null) {
            return notaService.findByUsuarioId(usuarioId, order);
        }
        return notaService.getAll();
    }

    @GetMapping("/{id}")
    public Nota getNotaById(@PathVariable Long id) {
        return notaService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Nota createNota(@RequestParam Long usuarioId, @Valid @RequestBody Nota nota) {
        Usuario usuario = usuarioService.getById(usuarioId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        
        nota.setUsuario(usuario);
        nota.setFechaCreacion(java.time.LocalDateTime.now());
        return notaService.save(nota);
    }

    @PutMapping("/{id}")
    public Nota updateNota(@PathVariable Long id, @Valid @RequestBody Nota notaActualizada) {
        Nota notaExistente = notaService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada"));
        
        // Mantener la fecha de creación original
        notaActualizada.setFechaCreacion(notaExistente.getFechaCreacion());
        // Mantener el usuario original
        notaActualizada.setUsuario(notaExistente.getUsuario());
        notaActualizada.setId(id);
        
        return notaService.update(id, notaActualizada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNota(@PathVariable Long id) {
        if (!notaService.getById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada");
        }
        notaService.deleteById(id);
    }
}