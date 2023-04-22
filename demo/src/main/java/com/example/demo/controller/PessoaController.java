package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaRepository repository;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Pessoa> getPessoa(@PathVariable int id) {
        return repository.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> getPessoas() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Pessoa atualizaPessoa(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);
    }
}
