package br.com.maxigenios.websystem.api.repository;

import br.com.maxigenios.websystem.api.domain.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

	AuthUser findByEmail(String email);
	
	//AuthUser findByCpfOrEmail(String cpf, String email);
}
