/**
 * 
 */
package br.gov.caixa.pedes.sistemas.sigde.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.caixa.pedes.sistemas.sigde.domain.Categoria;

/**
 * @author Leandro Severino - https://about.me/leandroseverino
 *
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}