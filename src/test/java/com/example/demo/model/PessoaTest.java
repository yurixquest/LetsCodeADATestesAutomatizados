package com.example.demo.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    String dataNascimento = "10/10/2000";

    @Test
    void setDataNascimento() {
        Pessoa pessoa = new Pessoa();
        pessoa.setDataNascimento(dataNascimento);

        assertEquals(dataNascimento, pessoa.getDataNascimento(), "Deveria vir a data 30-08-1998");
    }

    @Test
    void getPessoaId() {
        Pessoa pessoa = new Pessoa("Ana", "123.456.789", dataNascimento, "ana@gmail.com", BigDecimal.TEN);
        pessoa.setPessoaId(1);
        assertEquals(1, pessoa.getPessoaId(), "Deveria trazer o id: 1");
    }

    @Test
    void getDataNascimento() {
        Pessoa pessoa = new Pessoa("Ana", "123.456.789", dataNascimento, "ana@gmail.com", BigDecimal.TEN);

        assertEquals(dataNascimento, pessoa.getDataNascimento(), "Deveria trazer a data: 30-08-1998");
    }

    @Test
    void getCpf() {
        Pessoa pessoa = new Pessoa("Ana", "123.456.789", dataNascimento, "ana@gmail.com", BigDecimal.TEN);

        assertEquals("123.456.789", pessoa.getCpf(), "Deveria trazer o cpf: 123.456.789");
    }

    @Test
    void getEmail() {
        Pessoa pessoa = new Pessoa("Ana", "123.456.789", dataNascimento, "ana@gmail.com", BigDecimal.TEN);

        assertEquals("ana@gmail.com", pessoa.getEmail(), "Deveria trazer o email: ana@gmail.com");
    }

    @Test
    void getNome() {

        Pessoa pessoa = new Pessoa("Ana", "123.456.789", dataNascimento, "ana@gmail.com", BigDecimal.TEN);

        assertEquals("Ana", pessoa.getNome(), "Deveria trazer o nome: Ana");
    }

    @Test
    void getSaldo() {

        Pessoa pessoa = new Pessoa("Ana", "123.456.789", dataNascimento, "ana@gmail.com", BigDecimal.TEN);

        assertEquals(BigDecimal.TEN, pessoa.getSaldo(), "Deveria trazer o saldo 10");
    }

    @Test
    void setPessoaId() {
        Pessoa pessoa = new Pessoa();
        pessoa.setPessoaId(1L);

        assertEquals(1L, pessoa.getPessoaId(), "Deveria vir o id 1");
    }

    @Test
    void setCpf() {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("74056058857");

        assertEquals("74056058857", pessoa.getCpf(), "Deveria vir o cpf: 74056058857");
    }

    @Test
    void setEmail() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("ana@gmail.com");

        assertEquals("ana@gmail.com", pessoa.getEmail(), "Deveria vir o email ana@gmail.com");
    }

    @Test
    void setNome() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Ana");

        assertEquals("Ana", pessoa.getNome(), "Deveria vir o nome Ana");
    }

    @Test
    void setSaldo() {

        Pessoa pessoa = new Pessoa("Ana", "123.456.789", dataNascimento, "ana@gmail.com", BigDecimal.TEN);

        assertEquals(BigDecimal.TEN, pessoa.getSaldo(), "Deveria trazer o saldo: 10");
    }


}
