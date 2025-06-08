package com.tuapp.notasapi.service;

import com.tuapp.notasapi.model.Nota;
import java.util.List;

public interface NotaService extends CrudService<Nota, Long> {
    List<Nota> findByUsuarioId(Long usuarioId, String order);
}