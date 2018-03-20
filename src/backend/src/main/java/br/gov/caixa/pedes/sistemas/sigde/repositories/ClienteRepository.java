/**
 * 
 */
package br.gov.caixa.pedes.sistemas.sigde.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.gov.caixa.pedes.sistemas.sigde.domain.Cliente;

/**
 * @author Leandro Severino - https://about.me/leandroseverino
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Transactional(readOnly=true)
	Cliente findByEmail(String email);
	
}
