package br.com.maxigenios.websystem.api.service;


import br.com.maxigenios.websystem.api.domain.AuthUser;

import java.util.Optional;

public interface AuthUserService {
	
	/**
	 * Persiste um user na base de dados.
	 * 
	 * @param user
	 * @return AuthUser
	 */
	AuthUser save(AuthUser user);
	
	/**
	 * Busca e retorna um user dado um email.
	 * 
	 * @param email
	 * @return Optional<AuthUser>
	 */
	Optional<AuthUser> findByEmail(String email);
	
	/**
	 * Busca e retorna um user por ID.
	 * 
	 * @param id
	 * @return Optional<AuthUser>
	 */
	Optional<AuthUser> findById(Long id);

}