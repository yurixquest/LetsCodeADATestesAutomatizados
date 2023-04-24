package com.example.demo.service;

import com.example.demo.model.Livro;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.LivroRepository;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.repository.TransacaoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

class TransacaoServiceTest {

    private final PessoaRepository pessoarepository = Mockito.mock(PessoaRepository.class);
    private final LivroRepository livrorepository = Mockito.mock(LivroRepository.class);
    private final TransacaoRepository transacaoRepository = Mockito.mock(TransacaoRepository.class);
    private final TransacaoService transacaoService = new TransacaoService(transacaoRepository, pessoarepository, livrorepository);

    @Test
    void testCompraSemSaldo() throws Exception {
        LocalDate localDate5 = LocalDate.of(2018, 07, 22);
        Pessoa pessoa = new Pessoa("Maria", null, localDate5, null, BigDecimal.ZERO);
        Livro livro = new Livro("Paz", "Augusto Cury", null, BigDecimal.TEN, 1);

        when(pessoarepository.findById(Math.toIntExact(pessoa.getPessoaId()))).thenReturn(Optional.of(pessoa));
        when(livrorepository.findById(Math.toIntExact(livro.getLivroId()))).thenReturn(Optional.of(livro));


        transacaoService.realizarCompra(pessoa.getPessoaId(), livro.getLivroId());

        assertEquals("Saldo inicial da conta", BigDecimal.valueOf(0), pessoa.getSaldo());
    }

    @Test
    void testCompraComSaldoMaior() throws Exception {

    }

    @Test
    void testCompraComSaldoIgual() throws Exception {

    }

    @Test
    void testCompraComSaldoInsuficiente() throws Exception {

    }

    @Test
    void testCompraSaldoNegativo() throws Exception {

    }

    @Test
    void testLivroInvalido() throws Exception {

    }

    void testComLivroSemEstoque() {

    }

    void testComLivroComEstoque() {

    }

    void testComCompraTotalDoEstoque() {

    }


}

