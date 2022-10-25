package com.alura.boletim.services;

import com.alura.boletim.model.Alunos;
import com.alura.boletim.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AlunosServices {

    @Autowired
    AlunosRepository alunosRepository;

    public Page<Alunos> listAll(Pageable paginacao){
        return alunosRepository.findAll(paginacao);
    }

    public void save(Alunos alunos){
        alunosRepository.save(alunos);
    }

    public Optional<Alunos> get(Long id){
        return alunosRepository.findById(id);
    }

    public void deleteById(Long id) {
        alunosRepository.deleteById(id);
    }
}
