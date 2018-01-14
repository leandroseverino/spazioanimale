/**
 * 
 */
package br.gov.caixa.pedes.sistemas.sigde.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.caixa.pedes.sistemas.sigde.domain.Pagamento;

/**
 * @author Leandro Severino - https://about.me/leandroseverino
 *
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
