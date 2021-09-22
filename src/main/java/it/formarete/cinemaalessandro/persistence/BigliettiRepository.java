package it.formarete.cinemaalessandro.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.formarete.cinemaalessandro.domain.Biglietto;
import it.formarete.cinemaalessandro.domain.Cliente;




public interface BigliettiRepository extends CrudRepository<Biglietto, Integer> {

	 @Override
	    List<Biglietto> findAll();

	    @Query("SELECT b FROM Biglietto b WHERE cod_visitatore = ?1")
	    List<Biglietto> findByUser(Cliente cliente);
}
