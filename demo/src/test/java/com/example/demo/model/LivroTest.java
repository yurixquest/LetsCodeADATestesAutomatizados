package com.example.demo.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LivroTest {

    @Test
    void getNome() {
        Livro livro = new Livro("Ansiedade", "Augusto Cury", "Português", BigDecimal.TEN, 1);

        assertEquals("Ansiedade", livro.getNome(), "Deveria trazer o nome: Ansiedade");
    }

    @Test
    void setNome() {
        Livro livro = new Livro();
        livro.setNome("Ansiedade");

        assertEquals("Ansiedade", livro.getNome(), "Deveria trazer o nome: Ansiedade");
    }

    @Test
    void getEdicao() {
        Livro livro = new Livro("Ansiedade", "Augusto Cury", "Português", BigDecimal.TEN, 1);

        assertEquals("Português", livro.getEdicao(), "Deveria trazer a edição: Português");
    }

    @Test
    void setEdicao() {
        Livro livro = new Livro();
        livro.setEdicao("Português");

        assertEquals("Português", livro.getEdicao(), "Deveria trazer a edição: Português");
    }

    @Test
    void getAutor() {
        Livro livro = new Livro("Ansiedade", "Augusto Cury", "Português", BigDecimal.TEN, 1);

        assertEquals("Augusto Cury", livro.getAutor(), "Deveria trazer o autor: Augusto Cury");
    }

    @Test
    void setAutor() {
        Livro livro = new Livro();
        livro.setAutor("Augusto Cury");

        assertEquals("Augusto Cury", livro.getAutor(), "Deveria trazer o autor: Augusto Cury");
    }

    @Test
    void getQuantidade() {
        Livro livro = new Livro("Ansiedade", "Augusto Cury", "Português", BigDecimal.TEN, 1);

        assertEquals(1, livro.getQuantidade(), "Deveria trazer a quantidade: 1");
    }

    @Test
    void setQuantidade() {
        Livro livro = new Livro();
        livro.setQuantidade(1);

        assertEquals(1, livro.getQuantidade(), "Deveria trazer a quantidade: 1");
    }

    @Test
    void getLivroId() {
        Livro livro = new Livro("Ansiedade", "Augusto Cury", "Português", BigDecimal.TEN, 1);
        livro.setLivroId(1L);
        assertEquals(1, livro.getLivroId(), "Deveria trazer o id: 1");
    }

    @Test
    void getPreco() {
        Livro livro = new Livro("Ansiedade", "Augusto Cury", "Português", BigDecimal.TEN, 1);

        assertEquals(BigDecimal.TEN, livro.getPreco(), "Deveria trazer o preço: 10");
    }

    @Test
    void setLivroId() {
        Livro livro = new Livro();
        livro.setLivroId(1L);

        assertEquals(1L, livro.getLivroId(), "Deveria trazer o id: 1");
    }

    @Test
    void setPreco() {
        Livro livro = new Livro();
        livro.setPreco(BigDecimal.TEN);

        assertEquals(BigDecimal.TEN, livro.getPreco(), "Deveria trazer o preço: 10");
    }
}