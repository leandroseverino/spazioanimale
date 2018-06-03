package br.com.maxigenios.websystem.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.maxigenios.websystem.api.domain.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	//@Transactional(readOnly = true)
	//Empresa findByCnpj(String cnpj);

}
