package br.gov.caixa.pedes.sistemas.sigde.services.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import br.gov.caixa.pedes.sistemas.sigde.domain.Cliente;
import br.gov.caixa.pedes.sistemas.sigde.dto.ClienteDTO;
import br.gov.caixa.pedes.sistemas.sigde.repositories.ClienteRepository;
import br.gov.caixa.pedes.sistemas.sigde.resources.exception.FieldMessage;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteUpdate ann) {}

	@Override
	public boolean isValid(ClienteDTO objDTO, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE); 
		
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Cliente aux = repo.findByEmail(objDTO.getEmail());
		
		if (aux != null && !aux.getId().equals(uriId)) {
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