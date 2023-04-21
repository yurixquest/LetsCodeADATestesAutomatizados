package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "TRANSACAO")
public class Transacao {

    @Id
    @SequenceGenerator(name = "transacaoSequenceGenerator", sequenceName = "TRANSACAO_SQ", initialValue = 100)
    @GeneratedValue(generator = "transacaoSequenceGenerator", strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Integer transacaoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoaId")
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livroId")
    private Livro livro;

    private BigDecimal precoTotal;

    private BigDecimal saldo;

    //public int getId() {
    //    return transacaoId;
    //}

    //public void setId(Long id) {
     //   this.transacaoId = Math.toIntExact(id);
    //}

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public BigDecimal getPreco() {
        return precoTotal;
    }

    public void setPreco(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Transacao(Pessoa pessoa, Livro livro, BigDecimal saldo,BigDecimal precoTotal){
        this.pessoa = pessoa;
        this.livro = livro;
        this.saldo = saldo;
        this.precoTotal = precoTotal;
    };

    protected Transacao(){};

}


