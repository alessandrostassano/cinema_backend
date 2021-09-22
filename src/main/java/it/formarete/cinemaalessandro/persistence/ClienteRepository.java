package it.formarete.cinemaalessandro.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.formarete.cinemaalessandro.domain.Cliente;



public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

	@Query("SELECT c FROM Cliente c WHERE c.login=?1 AND c.password=?2")
	Cliente login(String username, String password);
	
}
