package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "PESSOA")
public class Pessoa {

    @Id
    @SequenceGenerator(name = "pessoaSequenceGenerator", sequenceName = "PESSOA_SQ", initialValue = 100)
    @GeneratedValue(generator = "pessoaSequenceGenerator", strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private long pessoaId;

    @Column(name = "DATA_NASCIMENTO")
    private String dataNascimento;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SALDO")
    private BigDecimal saldo;

    public Pessoa(String nome, String cpf, String dataNascimento, String email, BigDecimal saldo) {
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.saldo = saldo;
    }
    protected Pessoa() {
    }

    //@OneToMany(mappedBy = "pessoa")
    //private List<Transacao> transacoes;

    //public void setDataNascimento(LocalDate dataNascimento) {
        //if (dataNascimento.plusYears(18).isAfter(LocalDate.now())) {
          //  System.out.println("Valor inválido");
        //} else {
        //    this.dataNascimento = dataNascimento;
        //}


}
