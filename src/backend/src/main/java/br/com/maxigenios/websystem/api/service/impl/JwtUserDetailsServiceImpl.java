package br.com.maxigenios.websystem.api.service.impl;

import java.util.Optional;

import br.com.maxigenios.websystem.api.domain.AuthUser;
import br.com.maxigenios.websystem.api.security.JwtUserFactory;
import br.com.maxigenios.websystem.api.service.AuthUserService;
import br.com.maxigenios.websystem.api.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.maxigenios.websystem.api.domain.Funcionario;
import br.com.maxigenios.websystem.api.security.JwtUserFactory;
import br.com.maxigenios.websystem.api.service.FuncionarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AuthUserService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<AuthUser> usuario = service.findByEmail(username);
		
		if (usuario.isPresent()) {
			return JwtUserFactory.create(usuario.get());
		}
		
		throw new UsernameNotFoundException("Email not founded.");
	}
}
