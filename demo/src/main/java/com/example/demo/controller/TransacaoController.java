package com.example.demo.controller;


import com.example.demo.enums.StatusEnum;
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


    @PostMapping("/{trasacaoId}")
    @ResponseStatus(HttpStatus.CREATED)
    public StatusEnum realizarCompra(@PathVariable Long pessoaId, @PathVariable Long livroId) {
         return transacaoService.realizarCompra(pessoaId, livroId);
    }

    @PutMapping("/{transacaoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Transacao cancelarCompra(@PathVariable Integer transacaoId) {
        return transacaoService.cancelarTransacao(transacaoId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Transacao> getTransacoes() {
        return repository.findAll();
    }


}
