package com.alura.boletim.repository;

import com.alura.boletim.model.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<Alunos, Long> {

}
