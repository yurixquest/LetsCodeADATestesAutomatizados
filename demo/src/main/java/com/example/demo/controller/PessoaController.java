package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaRepository repository;

    @GetMapping("{id}")
    public Optional<Pessoa> getPessoa(@PathVariable int id) {
        return repository.findById(id);
    }

    @GetMapping
    public List<Pessoa> getPessoas() {
        return repository.findAll();
    }

    @PostMapping
    public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);
    }

    @PutMapping
    public Pessoa atualizaPessoa(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);
    }
}
