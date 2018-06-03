package br.com.maxigenios.websystem.api.security;

import java.util.ArrayList;
import java.util.List;

import br.com.maxigenios.websystem.api.domain.AuthUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.maxigenios.websystem.api.domain.Funcionario;
import br.com.maxigenios.websystem.api.enums.PerfilEnum;

public class JwtUserFactory {

	private JwtUserFactory() { }

	
	public static JwtUser create(AuthUser usuario) {
		return new JwtUser(usuario.getId(),
						   usuario.getEmail(),
						   usuario.getPassword(),
				           mapToGrantedAuthorities(usuario));
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(PerfilEnum perfilEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
		return authorities;
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(AuthUser user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (user.getIsSuperuser()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else {
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}


		return authorities;
	}
	
}
