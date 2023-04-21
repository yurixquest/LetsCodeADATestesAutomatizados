package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Component
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "LIVRO")
@Getter
@Setter
public class Livro {

    @Id
    @SequenceGenerator(name = "livroSequenceGenerator", sequenceName = "LIVRO_SQ", initialValue = 10000)
    @GeneratedValue(generator = "livroSequenceGenerator", strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private long livroId;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EDICAO")
    private String edicao;

    @Column(name = "AUTOR")
    private String autor;

    @Column(name = "QTD")
    private int quantidade;

    @Column(name = "PRECO")
    private BigDecimal preco;

    //@OneToMany(mappedBy = "livro")
   // private List<Transacao> transacoes;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Livro() {
    }

    public Livro(String nome, String autor,String edicao, BigDecimal preco, int quantidade) {
        this.nome = nome;
        this.autor = autor;
        this.edicao = edicao;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}
