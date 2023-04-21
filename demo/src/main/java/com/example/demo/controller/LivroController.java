package com.example.demo.controller;

import com.example.demo.model.Livro;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
public class LivroController {

    private final Livro livro;
    private final LivroRepository repository;

    @PostMapping
    public Livro createLivro(@RequestBody Livro livro) {
        return repository.save(livro);
    }

    @GetMapping
    public List<Livro> getLivros() {
        return repository.findAll();
    }



}
