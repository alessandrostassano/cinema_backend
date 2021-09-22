package it.formarete.cinemaalessandro.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.formarete.cinemaalessandro.domain.Cinema;





public interface CinemaRepository extends CrudRepository<Cinema, Integer> {
	@Override
    List<Cinema> findAll();

}
