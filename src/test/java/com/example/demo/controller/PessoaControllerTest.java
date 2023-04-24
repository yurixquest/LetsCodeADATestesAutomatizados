package com.example.demo.controller;


import com.example.demo.model.Pessoa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest (classes = PessoaControllerTest.class)
@AutoConfigureMockMvc
class PessoaControllerTest {

    @Autowired
    protected MockMvc mvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void createPessoaComNome() throws Exception {

        BigDecimal valor = BigDecimal.TEN;
        Pessoa criarpessoa = new Pessoa("Luis Antonio", "000.000.000-00", "08/08/1994", "email@email.com.br", valor);

        String response = mvc.perform(MockMvcRequestBuilders.post("/pessoas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(objectMapper.writeValueAsString(criarpessoa)))
                .andExpect(status().isCreated()).
                andReturn().getResponse().getContentAsString();

        String nomepessoa = JsonPath.read(response, "$.nome");

        assertEquals(criarpessoa.getNome(),nomepessoa, "Deveria ser criado um objeto do tipo pessoa");
    }

}