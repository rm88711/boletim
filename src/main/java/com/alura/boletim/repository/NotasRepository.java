package com.alura.boletim.repository;

import com.alura.boletim.model.Notas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotasRepository extends JpaRepository<Notas, Long> {

}
