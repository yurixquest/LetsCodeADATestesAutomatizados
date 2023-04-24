package com.example.demo.controller;

import com.example.demo.model.Livro;
import com.example.demo.repository.LivroRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



@SpringBootTest
@AutoConfigureMockMvc
class LivroControllerTest {
    @Autowired
    protected MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createLivroComNome() throws Exception {

        final LivroRepository repository;
        BigDecimal valor = BigDecimal.TEN;
        Livro criarlivro = new Livro("O Auto da Compadecida", "Ariano Suassuna", "1 ed", valor, 20);

        String response = mvc.perform(MockMvcRequestBuilders.post("/livro")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(criarlivro)))
                .andExpect(status().isCreated()).
                andReturn().getResponse().getContentAsString();

        String nomeLivro = JsonPath.read(response, "$.nome");
        String autorLivro = JsonPath.read(response, "$.autor");
        String edicaoLivro = JsonPath.read(response, "$.edicao");
        BigDecimal valorLivro = JsonPath.read(response, "$.preco");
        Integer qtdLivro = JsonPath.read(response, "$.quantidade");

        assertFalse(autorLivro.isBlank(), "Deveria ser criado um objeto do tipo livro que possua um autor");
        assertFalse(nomeLivro.isBlank(), "Deveria ser criado um objeto do tipo livro que possua um nome");
        assertFalse(edicaoLivro.isBlank(), "Deveria ser criado um objeto do tipo livro que possua uma edição");
        assertTrue(valorLivro.compareTo(BigDecimal.ZERO) > 0, "O preço do livro deveria ser maior do que zero");
        assertTrue(qtdLivro > 0, "Deveria ser criado um objeto do tipo livro que possua quantidade acima de zero");


    }

    @Test
    void testGetLivros() throws Exception {
        final LivroRepository repository;
        BigDecimal valor = BigDecimal.TEN;
        Livro criarlivro = new Livro("O Auto da Compadecida", "Ariano Suassuna", "1 ed", valor, 20);

        mvc.perform(MockMvcRequestBuilders.post("/livro")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(criarlivro)));

        String result = mvc.perform(get("/livro"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<Livro> livros = objectMapper.readValue(result, new TypeReference<List<Livro>>(){});

        assertTrue(livros.size() > 0, "Deveria retornar pelo menos um livro cadastrado");
    }


}