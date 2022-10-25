package com.alura.boletim.controller;
import com.alura.boletim.model.Alunos;
import com.alura.boletim.services.AlunosServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunosServices service;

    @GetMapping
    public Page<Alunos> index(@PageableDefault(size=50) Pageable paginacao){
        return service.listAll(paginacao);
    }

    @PostMapping
    public ResponseEntity<Alunos> create(@RequestBody @Valid Alunos alunos){
        service.save(alunos);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Alunos> show(@PathVariable Long id){
        return ResponseEntity.of(service.get(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        Optional<Alunos> optional = service.get(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Alunos> update(@PathVariable Long id, @RequestBody @Valid Alunos newAlunos){
        // carregar a tarefa do banco
        Optional<Alunos> optional = service.get(id);

        // verificar se existe a tarefa com esse id
        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        // atualizar os dados
        Alunos alunos = optional.get();
        BeanUtils.copyProperties(newAlunos, alunos);
        alunos.setIdAluno(id);

        // salvar a tarefa
        service.save(alunos);

        return ResponseEntity.ok(alunos);

    }

}
