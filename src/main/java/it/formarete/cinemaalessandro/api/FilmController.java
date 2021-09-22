package it.formarete.cinemaalessandro.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.formarete.cinemaalessandro.domain.Film;
import it.formarete.cinemaalessandro.persistence.FilmRepository;




@RestController
@RequestMapping("/film")
@CrossOrigin(origins = "http://localhost:*")
public class FilmController {


	@Autowired
	private FilmRepository film;
	
	
	@GetMapping
	public Iterable<Film>all(){
		return  film.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Film get(@PathVariable Integer id){
		return film.findById(id).orElseThrow(( ) -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Movie not found"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Film create(@RequestBody Film body) {
		return film.save(body);
	}
	
	@PutMapping("/{id}")
	public Film replace(@PathVariable Integer id , @RequestBody Film body) {
		Film it = get(id);
		body.setCod_film(it.getCod_film());
		return film.save(body);
	}
	
	@PatchMapping("/{id}")
	public Film modify (@PathVariable Integer id , @RequestBody Film body) {
		Film it = get(id);
		if(body.getCinema() != null) {
			it.setCinema(body.getCinema());
		}
		if(body.getPrice() != null) {
			it.setPrice(body.getPrice());
		}
		if(body.getStartDate() != null) {
			it.setStartDate(body.getStartDate());
		}
		if(body.getEndDate() != null) {
			it.setEndDate(body.getEndDate());
		}
		return film.save(it);
	}
	
	@DeleteMapping("/{id}")
	public Film remove(@PathVariable Integer id , @RequestBody Film body) {
		Film us = get(id);
		film.delete(us);
		return us;
	}
}
