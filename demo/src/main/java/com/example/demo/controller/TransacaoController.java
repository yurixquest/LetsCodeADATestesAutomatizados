package com.example.demo.controller;


import com.example.demo.model.Livro;
import com.example.demo.model.Pessoa;
import com.example.demo.model.Transacao;

import com.example.demo.repository.LivroRepository;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.repository.TransacaoRepository;
import com.example.demo.service.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    private Transacao transacao;
    @Autowired
    private TransacaoRepository repository;


    @PostMapping("/{pessoaId}/comprar/{livroId}")
    public ResponseEntity<Void> realizarCompra(@PathVariable Long pessoaId, @PathVariable Long livroId) {
        transacaoService.realizarCompra(pessoaId, livroId);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping
    public List<Transacao> getTransacoes() {
        return repository.findAll();
    }
}
