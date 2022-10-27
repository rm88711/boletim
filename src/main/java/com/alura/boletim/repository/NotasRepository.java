package com.alura.boletim.repository;

import com.alura.boletim.model.Notas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotasRepository extends JpaRepository<Notas, Long> {
    Optional<Notas> findByIdAluno(Long idAluno);
}
