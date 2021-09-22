package it.formarete.cinemaalessandro.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.formarete.cinemaalessandro.domain.Film;



public interface FilmRepository extends CrudRepository<Film, Integer> {

	  @Override
	    List<Film> findAll();
}
