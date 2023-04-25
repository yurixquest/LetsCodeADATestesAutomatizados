package com.example.demo.service;

import com.example.demo.enums.StatusEnum;
import com.example.demo.model.Livro;
import com.example.demo.model.Pessoa;
import com.example.demo.model.Transacao;
import com.example.demo.repository.LivroRepository;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.repository.TransacaoRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class TransacaoService {

    private TransacaoRepository transacaorepository;
    private PessoaRepository pessoaRepository;
    private LivroRepository livroRepository;




    public StatusEnum realizarCompra(Long pessoaId, Long livroId) {
        Pessoa pessoa = pessoaRepository.findById(Math.toIntExact(pessoaId)).orElseThrow();
        Livro livro = livroRepository.findById(Math.toIntExact(livroId)).orElseThrow();
        Transacao transacao = new Transacao(pessoa, livro, pessoa.getSaldo(), livro.getPreco());
        BigDecimal pessoaSaldo = pessoa.getSaldo();
        BigDecimal precoLivro = livro.getPreco();

        System.out.println(transacao);
        System.out.println(transacaorepository);


        if (pessoaSaldo.compareTo(precoLivro) >= 0 && livro.getQuantidade() > 0) {
            System.out.println(pessoa.getNome() + " possui saldo para compra do livro " + livro.getNome());
            BigDecimal custo = pessoaSaldo.subtract(precoLivro);
            pessoa.setSaldo(custo);
            livro.setQuantidade(livro.getQuantidade() - 1);
            transacao.setStatus(StatusEnum.COMPRA);
        } else {
            transacao.setStatus(StatusEnum.NEGADO);
        }
        transacaorepository.save(transacao);
        return transacao.getStatus();
    }

    public Transacao cancelarTransacao(Integer transacaoId) {
        Transacao transacao = transacaorepository.getReferenceById(transacaoId);
        if(transacao.getStatus().equals(StatusEnum.COMPRA)) {
            Livro livro = transacao.getLivro();
            livro.setQuantidade(livro.getQuantidade() + 1);
            Pessoa pessoa = transacao.getPessoa();
            pessoa.setSaldo(pessoa.getSaldo().add(livro.getPreco()));
            transacao.cancelarTransacao();
        }

        return transacao;
    }
}

