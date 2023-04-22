package com.example.demo.controller;

import com.example.demo.model.Livro;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
public class LivroController {

    private final Livro livro;
    private final LivroRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro createLivro(@RequestBody Livro livro) {
        return repository.save(livro);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Livro> getLivros() {
        return repository.findAll();
    }



}
