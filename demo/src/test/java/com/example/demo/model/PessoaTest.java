package com.example.demo.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void setDataNascimento() {
    }

    @Test
    void getPessoaId() {
    }

    @Test
    void getDataNascimento() {
    }

    @Test
    void getCpf() {
    }

    @Test
    void getEmail() {
    }

    @Test
    void getNome() {
    }

    @Test
    void getSaldo() {
        LocalDate localDate5 = LocalDate.now();
        Pessoa pessoa = new Pessoa("Ana", "123.456.789", localDate5, "ana@gmail.com", BigDecimal.TEN);

        assertEquals(BigDecimal.TEN, pessoa.getSaldo(), "Deveria trazer o saldo 10");
    }

    @Test
    void setPessoaId() {
    }

    @Test
    void setCpf() {
    }

    @Test
    void setEmail() {
    }

    @Test
    void setNome() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Ana");

        assertEquals("Ana", pessoa.getNome(), "Deveria vir o nome Ana");
    }

    @Test
    void setSaldo() {
    }


}