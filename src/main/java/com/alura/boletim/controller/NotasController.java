package com.alura.boletim.controller;
import com.alura.boletim.model.Notas;
import com.alura.boletim.services.NotasService;
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
@RequestMapping("/api/notas")
public class NotasController {
    @Autowired
    private NotasService service;

    @GetMapping
    public Page<Notas> index(@PageableDefault(size=50) Pageable paginacao){
        return service.listAll(paginacao);
    }

    @PostMapping
    public ResponseEntity<Notas> create(@RequestBody @Valid Notas notas){
        service.save(notas);
        return ResponseEntity.status(HttpStatus.CREATED).body(notas);
    }

    @GetMapping("{id}")
    public ResponseEntity<Notas> show(@PathVariable Long id){
        return ResponseEntity.of(service.get(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        Optional<Notas> optional = service.get(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Notas> update(@PathVariable Long id, @RequestBody @Valid Notas newNotas){
        // carregar a tarefa do banco
        Optional<Notas> optional = service.get(id);

        // verificar se existe a tarefa com esse id
        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        // atualizar os dados
        Notas notas = optional.get();
        BeanUtils.copyProperties(newNotas, notas);
        notas.setIdNota(id);

        // salvar a tarefa
        service.save(notas);

        return ResponseEntity.ok(notas);

    }
}
