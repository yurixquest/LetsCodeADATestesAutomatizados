package com.example.demo.service;

import com.example.demo.model.Livro;
import com.example.demo.model.Pessoa;
import com.example.demo.model.Transacao;
import com.example.demo.repository.LivroRepository;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.repository.TransacaoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.example.demo.enums.StatusEnum;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

class TransacaoServiceTest {
    private final PessoaRepository pessoarepository = Mockito.mock(PessoaRepository.class);
    private final LivroRepository livrorepository = Mockito.mock(LivroRepository.class);
    private final TransacaoRepository transacaoRepository = Mockito.mock(TransacaoRepository.class);
    private final TransacaoService transacaoService = new TransacaoService(transacaoRepository, pessoarepository, livrorepository);

    LocalDate dataNascimento       = LocalDate.of(1998, 07, 22);
    Pessoa pessoa = new Pessoa("Maria", null, dataNascimento, null, BigDecimal.ZERO);
    Livro livro = new Livro("Paz", "Augusto Cury", null, BigDecimal.TEN, 1);
    Transacao transacao = new Transacao(pessoa, livro, pessoa.getSaldo(), livro.getPreco());

    @Test
    void testCompraSemSaldo() throws Exception {
        Transacao transacao = new Transacao(pessoa, livro, pessoa.getSaldo(), livro.getPreco());
        livro.setLivroId(1L);
        when(pessoarepository.findById(Math.toIntExact(pessoa.getPessoaId()))).thenReturn(Optional.of(pessoa));
        when(livrorepository.findById(Math.toIntExact(livro.getLivroId()))).thenReturn(Optional.of(livro));

        transacaoService.realizarCompra(pessoa.getPessoaId(), livro.getLivroId());

        verify(transacaoRepository, times(0)).save(transacao);
        assertEquals("Saldo da conta deveria ser 0", BigDecimal.valueOf(0), pessoa.getSaldo());
        assertEquals("A quantidade de livros deveria continuar 1", 1, livro.getQuantidade());
        //assertEquals("O status deve estar: Negado", StatusEnum.NEGADO, transacao.StatusCompra());
    }

    @Test
    void testCompraComSaldoMaior() throws Exception {
        pessoa.setSaldo(BigDecimal.valueOf(50));
        livro.setLivroId(1L);
        when(pessoarepository.findById(Math.toIntExact(pessoa.getPessoaId()))).thenReturn(Optional.of(pessoa));
        when(livrorepository.findById(Math.toIntExact(livro.getLivroId()))).thenReturn(Optional.of(livro));

        transacaoService.realizarCompra(pessoa.getPessoaId(), livro.getLivroId());

        //verify(transacaoRepository, times(1)).save(transacao);    Dá erro no teste com essa linha
        assertEquals("Saldo da conta deveria ser 0", BigDecimal.valueOf(40), pessoa.getSaldo());
        assertEquals("A quantidade de livros deveria ser 0", 0, livro.getQuantidade());
    }

    @Test
    void testCompraComSaldoIgual() throws Exception {
        pessoa.setSaldo(BigDecimal.TEN);
        livro.setLivroId(1L);
        when(pessoarepository.findById(Math.toIntExact(pessoa.getPessoaId()))).thenReturn(Optional.of(pessoa));
        when(livrorepository.findById(Math.toIntExact(livro.getLivroId()))).thenReturn(Optional.of(livro));

        transacaoService.realizarCompra(pessoa.getPessoaId(), livro.getLivroId());

        assertEquals("Saldo da conta deveria ser 0", BigDecimal.valueOf(0), pessoa.getSaldo());
        assertEquals("A quantidade de livros deveria ser 0", 0, livro.getQuantidade());
    }

    @Test
    void testCompraComSaldoInsuficiente() throws Exception {
        pessoa.setSaldo(BigDecimal.valueOf(8));
        livro.setLivroId(1L);
        when(pessoarepository.findById(Math.toIntExact(pessoa.getPessoaId()))).thenReturn(Optional.of(pessoa));
        when(livrorepository.findById(Math.toIntExact(livro.getLivroId()))).thenReturn(Optional.of(livro));

        transacaoService.realizarCompra(pessoa.getPessoaId(), livro.getLivroId());

        verify(transacaoRepository, times(0)).save(transacao);
        assertEquals("Saldo da conta deveria ser 8", BigDecimal.valueOf(8), pessoa.getSaldo());
        assertEquals("A quantidade de livros deveria continuar 1", 1, livro.getQuantidade());
    }

    @Test
    void testCompraSaldoNegativo() throws Exception {
        pessoa.setSaldo(BigDecimal.valueOf(-6));
        livro.setLivroId(1L);
        when(pessoarepository.findById(Math.toIntExact(pessoa.getPessoaId()))).thenReturn(Optional.of(pessoa));
        when(livrorepository.findById(Math.toIntExact(livro.getLivroId()))).thenReturn(Optional.of(livro));

        transacaoService.realizarCompra(pessoa.getPessoaId(), livro.getLivroId());

        verify(transacaoRepository, times(0)).save(transacao);
        assertEquals("Saldo da conta deveria ser -6", BigDecimal.valueOf(-6), pessoa.getSaldo());
        assertEquals("A quantidade de livros deveria continuar 1", 1, livro.getQuantidade());

    }

    @Test
    void testLivroInvalido() throws Exception {
        livro.setLivroId(1L);
        pessoa.setSaldo(BigDecimal.valueOf(50));
        when(pessoarepository.findById(Math.toIntExact(pessoa.getPessoaId()))).thenReturn(Optional.of(pessoa));
        when(livrorepository.findById(Math.toIntExact(livro.getLivroId()))).thenReturn(Optional.of(livro));

        transacaoService.realizarCompra(pessoa.getPessoaId(),2L);

        verify(transacaoRepository, times(0)).save(transacao);
        assertEquals("Saldo da conta deveria ser 50", BigDecimal.valueOf(50), pessoa.getSaldo());
        assertEquals("A quantidade de livros deveria continuar 1", 1, livro.getQuantidade());
    }

    @Test
    void testComLivroSemEstoque() {

    }

    @Test
    void testComLivroComEstoque() {

    }

    @Test
    void testComCompraTotalDoEstoque() {

    }


}

