/**
 * 
 */
package br.gov.caixa.pedes.sistemas.sigde.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.caixa.pedes.sistemas.sigde.domain.Endereco;

/**
 * @author Leandro Severino - https://about.me/leandroseverino
 *
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}