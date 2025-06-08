package com.tuapp.notasapi.service;

import com.tuapp.notasapi.model.Nota;
import com.tuapp.notasapi.repository.NotaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImpl extends AbstractCrudService<Nota, Long> implements NotaService {

    private final NotaRepository notaRepository;

    public NotaServiceImpl(NotaRepository repository) {
        super(repository);
        this.notaRepository = repository;
    }

    @Override
    public List<Nota> findByUsuarioId(Long usuarioId, String order) {
        Sort sort = Sort.by("fechaCreacion").ascending();
        if ("desc".equalsIgnoreCase(order)) {
            sort = sort.descending();
        }
        return notaRepository.findByUsuarioId(usuarioId, sort);
    }
}