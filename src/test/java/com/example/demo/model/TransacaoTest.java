package com.example.demo.model;

import com.example.demo.enums.StatusEnum;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoTest {
    String dataNascimento = "10/10/2000";
    Pessoa pessoa = new Pessoa("Ana", "123.456.789", dataNascimento, "ana@gmail.com", BigDecimal.TEN);
    Livro livro = new Livro("Ansiedade", "Augusto Cury", "Português", BigDecimal.TEN, 1);
    BigDecimal saldo = BigDecimal.valueOf(100.0);
    BigDecimal precoTotal = BigDecimal.valueOf(50.0);

    @Test
    void getPessoa() {
        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);

        assertEquals(pessoa, transacao.getPessoa(), "Deveria trazer a pessoa: Ana");
    }

    @Test
    void setPessoa() {
        Pessoa pessoa2 = new Pessoa("Maria", "789.456.222", dataNascimento, "maria@gmail.com", BigDecimal.TEN);

        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);

        transacao.setPessoa(pessoa2);

        assertEquals(pessoa2, transacao.getPessoa(), "Deveria trazer a pessoa: Maria");
    }

    @Test
    void getLivro() {
        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);

        assertEquals(livro, transacao.getLivro(), "Deveria trazer o livro: Ansiedade");
    }

    @Test
    void setLivro() {
        Livro livro2 = new Livro("O vendedor de Sonhos", "Augusto Cury", "Português", BigDecimal.TEN, 1);

        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);
        transacao.setLivro(livro2);

        assertEquals(livro2, transacao.getLivro(), "Deveria trazer o livro: O vendedor de sonhos");
    }

    @Test
    void getPreco() {
        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);

        assertEquals(precoTotal, transacao.getPreco(), "Deveria trazer o preco: 50");
    }

    @Test
    void setPreco() {
        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);
        transacao.setPreco(BigDecimal.valueOf(20));

        assertEquals(BigDecimal.valueOf(20), transacao.getPreco(), "Deveria trazer o preco: 20");
    }

    @Test
    void getSaldo() {
        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);

        assertEquals(saldo, transacao.getSaldo(), "Deveria trazer o saldo: 100");
    }

    @Test
    void setSaldo() {
        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);

        transacao.setSaldo(BigDecimal.valueOf(30));

        assertEquals(BigDecimal.valueOf(30), transacao.getSaldo(), "Deveria trazer o saldo: 30");
    }

    @Test
    void getStatus() {
        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);

        transacao.setStatus(StatusEnum.COMPRA);

        assertEquals(StatusEnum.COMPRA, transacao.getStatus(), "Deveria trazer o status: COMPRA");
    }

    @Test
    void setStatus() {
        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);

        transacao.setStatus(StatusEnum.COMPRA);

        assertEquals(StatusEnum.COMPRA, transacao.getStatus(), "Deveria trazer o status: COMPRA");
    }

    @Test
    void getStatusCompra() {
        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);

        transacao.setStatusCompra(StatusEnum.COMPRA);

        assertEquals(StatusEnum.COMPRA, transacao.getStatusCompra(), "Deveria trazer o status: COMPRA");
    }

    @Test
    void setStatusCompra() {
        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);

        transacao.setStatusCompra(StatusEnum.COMPRA);

        assertEquals(StatusEnum.COMPRA, transacao.getStatusCompra(), "Deveria trazer o status: COMPRA");
    }

    @Test
    void cancelarTransacao() {
        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);

        transacao.cancelarTransacao();

        assertEquals(StatusEnum.CANCELAMENTO, transacao.getStatusCompra(), "Deveria trazer o preco 10");
    }

    @Test
    void getPrecoTotal() {
        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);

        assertEquals(precoTotal, transacao.getPrecoTotal(), "Deveria trazer o preco: 50");
    }

    @Test
    void setPrecoTotal() {
        Transacao transacao = new Transacao(pessoa, livro, saldo, precoTotal);

        transacao.setPrecoTotal(BigDecimal.valueOf(60));

        assertEquals(BigDecimal.valueOf(60), transacao.getPrecoTotal(), "Deveria trazer o preco: 60");
    }
}
