package com.alura.boletim.services;

import com.alura.boletim.model.Notas;
import com.alura.boletim.repository.NotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotasService {

    @Autowired
    NotasRepository notasRepository;

    public Page<Notas> listAll(Pageable paginacao){
        return notasRepository.findAll(paginacao);
    }

    public void save(Notas notas){
        notasRepository.save(notas);
    }

    public Optional<Notas> get(Long id){
        return notasRepository.findById(id);
    }

    public void deleteById(Long id) {
        notasRepository.deleteById(id);
    }
}
