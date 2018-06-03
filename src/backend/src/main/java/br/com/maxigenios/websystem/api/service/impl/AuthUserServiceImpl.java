package br.com.maxigenios.websystem.api.service.impl;

import br.com.maxigenios.websystem.api.domain.AuthUser;
import br.com.maxigenios.websystem.api.repository.AuthUserRepository;
import br.com.maxigenios.websystem.api.service.AuthUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserServiceImpl implements AuthUserService {
	
	private static final Logger log = LoggerFactory.getLogger(AuthUserServiceImpl.class);

	@Autowired
	private AuthUserRepository AuthUserRepository;
	
	public AuthUser save(AuthUser AuthUser) {
		log.info("Persistindo funcionário: {}", AuthUser);
		return this.AuthUserRepository.save(AuthUser);
	}
	
	public Optional<AuthUser> findByEmail(String email) {
		log.info("Buscando funcionário pelo email {}", email);
		return Optional.ofNullable(this.AuthUserRepository.findByEmail(email));
	}
	
	public Optional<AuthUser> findById(Long id) {
		log.info("Buscando funcionário pelo IDl {}", id);
		return Optional.ofNullable(this.AuthUserRepository.findOne(id));
	}

}
