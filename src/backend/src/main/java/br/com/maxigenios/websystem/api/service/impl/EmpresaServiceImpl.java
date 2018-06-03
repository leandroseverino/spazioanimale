package br.com.maxigenios.websystem.api.service.impl;

import java.util.Optional;

import br.com.maxigenios.websystem.api.repository.EmpresaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maxigenios.websystem.api.domain.Empresa;
import br.com.maxigenios.websystem.api.repository.EmpresaRepository;
import br.com.maxigenios.websystem.api.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Optional<Empresa> findByCnpj(String cnpj) {
		log.info("Buscando uma empresa para o CNPJ {}", cnpj);
		//return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
		return null;
	}

	@Override
	public Empresa save(Empresa empresa) {
		log.info("Persistindo empresa: {}", empresa);
		return this.empresaRepository.save(empresa);
	}

}