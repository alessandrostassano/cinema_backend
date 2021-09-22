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

import it.formarete.cinemaalessandro.domain.Cinema;
import it.formarete.cinemaalessandro.persistence.CinemaRepository;



@RestController
@RequestMapping("/cinema")
@CrossOrigin(origins = "http://localhost:*")
public class CinemaController {

	@Autowired
	private CinemaRepository cinema;
	
	
	@GetMapping
	public Iterable<Cinema>getAll(){
		return cinema.findAll();
	}
	
	@GetMapping("/{id}")
	public Cinema getOne(@PathVariable Integer id) {
		return cinema.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cinema not found"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cinema create(@RequestBody Cinema body) {
		return cinema.save(body);
	}
	
	@PutMapping("/{id}")
	public Cinema replace(@PathVariable Integer id, @RequestBody Cinema body) {
		Cinema cinema12 = getOne(id);
		body.setCod_cinema(cinema12.getCod_cinema());
		return cinema.save(body);
	}
	
	@PatchMapping("/{id}")
	public Cinema modify(@PathVariable Integer id, @RequestBody Cinema body) {
		Cinema cxc = getOne(id);
		if (body.getAddress() != null) {
			cxc.setAddress(body.getAddress());
		}
		if (body.getCity() != null) {
			cxc.setCity(body.getCity());
		}
		if (body.getProvince() != null) {
			cxc.setProvince(body.getProvince());
		}
		if (body.getName() != null) {
			cxc.setName(body.getName());
		}
		if (body.getTelephone() != null) {
			cxc.setTelephone(body.getTelephone());
		}
		if (body.getMaxVisitors() != null) {
			cxc.setMaxVisitors(body.getMaxVisitors());
		}
		return cinema.save(cxc);
	}
	
	@DeleteMapping("/{id}")
	public Cinema remove(@PathVariable Integer id, @RequestBody Cinema body) {
		Cinema cinemax = getOne(id);
		cinema.delete(cinemax);
		return cinemax;
	}
	
	
}
