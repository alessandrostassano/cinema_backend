package it.formarete.cinemaalessandro.api;

import java.util.List;

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

import it.formarete.cinemaalessandro.domain.Biglietto;
import it.formarete.cinemaalessandro.domain.Cliente;
import it.formarete.cinemaalessandro.persistence.BigliettiRepository;





@RestController
@RequestMapping("/biglietti")
@CrossOrigin(origins = "http://localhost:*")
public class BigliettiController {

	@Autowired
	private BigliettiRepository biglietti;
	
	
	@GetMapping
	public Iterable<Biglietto>all(){
		return biglietti.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Biglietto get(@PathVariable Integer id){
		return biglietti.findById(id).orElseThrow(( ) -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Ticket not found"));
	}
	
	@PostMapping("/visualizza")
    public List<Biglietto> search(@RequestBody Cliente body){
        System.out.println("body: "+body);

        return biglietti.findByUser(body);
    }

    @PostMapping("/add")
    public Biglietto add(@RequestBody Biglietto body){
        System.out.println("body: "+body);
        return biglietti.save(body);
    }
	
	@PutMapping("/{id}")
	public Biglietto replace(@PathVariable Integer id , @RequestBody Biglietto body) {
		Biglietto it = get(id);
		body.setCod_operazione(it.getCod_operazione());
		return biglietti.save(body);
	}
	
	@PatchMapping("/{id}")
	public Biglietto modify (@PathVariable Integer id , @RequestBody Biglietto body) {
		Biglietto it = get(id);
		if(body.getFilm() != null) {
			it.setFilm(body.getFilm());
		}
		if(body.getQuantity() != null) {
			it.setQuantity(body.getQuantity());
		}
		return biglietti.save(it);
	}
	
	@DeleteMapping("/{id}")
	public Biglietto remove(@PathVariable Integer id , @RequestBody Biglietto body) {
		Biglietto us = get(id);
		biglietti.delete(us);
		return us;
	}
}
