package br.com.maxigenios.websystem.api.service;

import static org.junit.Assert.*;

import java.util.Optional;

import br.com.maxigenios.websystem.api.domain.Funcionario;
import br.com.maxigenios.websystem.api.repository.FuncionarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.maxigenios.websystem.api.domain.Funcionario;
import br.com.maxigenios.websystem.api.repository.FuncionarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioServiceTest {

	@MockBean
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private FuncionarioService funcionarioService;

	@Before
	public void setUp() throws Exception {
		BDDMockito
			.given(this.funcionarioRepository.save(Mockito.any(Funcionario.class)))
			.willReturn(new Funcionario());
		BDDMockito
			.given(this.funcionarioRepository.findOne(Mockito.anyLong()))
			.willReturn(new Funcionario());
		BDDMockito
			.given(this.funcionarioRepository.findByEmail(Mockito.anyString()))
			.willReturn(new Funcionario());
		BDDMockito
			.given(this.funcionarioRepository.findByCpf(Mockito.anyString()))
			.willReturn(new Funcionario());
	}

	@Test
	public void testSave() {
		Funcionario funcionario = this.funcionarioService.save(new Funcionario());

		assertNotNull(funcionario);
	}

	@Test
	public void testFindById() {
		Optional<Funcionario> funcionario = this.funcionarioService.findById(1L);

		assertTrue(funcionario.isPresent());
	}

	@Test
	public void testFindByEmail() {
		Optional<Funcionario> funcionario = this.funcionarioService.findByEmail("email@email.com");

		assertTrue(funcionario.isPresent());
	}

	@Test
	public void testFindByCpf() {
		Optional<Funcionario> funcionario = this.funcionarioService.findByCpf("24291173474");

		assertTrue(funcionario.isPresent());
	}

}