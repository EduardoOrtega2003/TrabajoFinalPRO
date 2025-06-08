package com.tuapp.notasapi.repository;

import com.tuapp.notasapi.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByUsuarioId(Long usuarioId, Sort sort);
}