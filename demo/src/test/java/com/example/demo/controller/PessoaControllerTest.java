package com.example.demo.controller;

import com.example.demo.model.Livro;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.LivroRepository;
import com.example.demo.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PessoaControllerTest {

    @Autowired
    protected MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final String baseUri = "/pessoas";


    @Test
    void createPessoaComNome() throws Exception {

        final PessoaRepository repository;
        BigDecimal valor = BigDecimal.TEN;
        Pessoa criarpessoa = new Pessoa("Luis Antonio", "000.000.000-00", "08/08/1994", "email@email.com.br", valor);

        String response = mvc.perform(MockMvcRequestBuilders.post("/pessoas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(criarpessoa)))
                .andExpect(status().isCreated()).
                andReturn().getResponse().getContentAsString();

        String nomepessoa = JsonPath.read(response, "$.nome");

        assertEquals(criarpessoa.getNome(),nomepessoa, "Deveria ser criado um objeto do tipo pessoa");
    }

}