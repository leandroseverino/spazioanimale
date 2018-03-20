package br.gov.caixa.pedes.sistemas.sigde.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.caixa.pedes.sistemas.sigde.domain.Cliente;
import br.gov.caixa.pedes.sistemas.sigde.domain.enums.TipoCliente;
import br.gov.caixa.pedes.sistemas.sigde.dto.ClienteNewDTO;
import br.gov.caixa.pedes.sistemas.sigde.repositories.ClienteRepository;
import br.gov.caixa.pedes.sistemas.sigde.resources.exception.FieldMessage;
import br.gov.caixa.pedes.sistemas.sigde.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {}

	@Override
	public boolean isValid(ClienteNewDTO objDTO, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if (objDTO.getTipo() == null) {
			list.add(new FieldMessage("tipo", "Tipo não pode ser nulo"));
		}
		
		if (objDTO.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDTO.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido !"));
		}
		
		if (objDTO.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDTO.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido !"));
		}
		
		Cliente aux = repo.findByEmail(objDTO.getEmail());
		
		if (aux != null ) {
			list.add(new FieldMessage("email", "E-mail já existente na base de dados !"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
}