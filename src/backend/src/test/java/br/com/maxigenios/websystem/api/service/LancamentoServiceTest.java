package br.com.maxigenios.websystem.api.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Optional;

import br.com.maxigenios.websystem.api.domain.Lancamento;
import br.com.maxigenios.websystem.api.repository.LancamentoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.maxigenios.websystem.api.domain.Lancamento;
import br.com.maxigenios.websystem.api.repository.LancamentoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoServiceTest {

	@MockBean
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private LancamentoService lancamentoService;

	@Before
	public void setUp() throws Exception {
		BDDMockito
			.given(this.lancamentoRepository.findByFuncionarioId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
			.willReturn(new PageImpl<Lancamento>(new ArrayList<Lancamento>()));
		BDDMockito
			.given(this.lancamentoRepository.findOne(Mockito.anyLong()))
			.willReturn(new Lancamento());
		BDDMockito
			.given(this.lancamentoRepository.save(Mockito.any(Lancamento.class)))
			.willReturn(new Lancamento());
	}

	@Test
	public void testFindByFuncionarioId() {
		Page<Lancamento> lancamento = this.lancamentoService.findByFuncionarioId(1L, new PageRequest(0, 10));

		assertNotNull(lancamento);
	}

	@Test
	public void testFindById() {
		Optional<Lancamento> lancamento = this.lancamentoService.findById(1L);

		assertTrue(lancamento.isPresent());
	}

	@Test
	public void testSave() {
		Lancamento lancamento = this.lancamentoService.save(new Lancamento());

		assertNotNull(lancamento);
	}

}