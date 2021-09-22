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

import it.formarete.cinemaalessandro.domain.Cliente;
import it.formarete.cinemaalessandro.domain.Clientemodel;
import it.formarete.cinemaalessandro.persistence.ClienteRepository;




@RestController
@RequestMapping("/clienti")
@CrossOrigin(origins = "http://localhost:*")
public class ClienteController {

	@Autowired
	private ClienteRepository clienti;
	
	
	@GetMapping
	public Iterable<Cliente>all(){
		return   clienti.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Cliente get(@PathVariable Integer id){
		return clienti.findById(id).orElseThrow(( ) -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Visitor not found"));
	}
	
	@PostMapping("/add")
    public Cliente add(@RequestBody Cliente body){
        System.out.println("body: "+body);
        return clienti.save(body);
    }

    @PostMapping("/login")
    public Cliente login(@RequestBody Clientemodel body){
        System.out.println("body "+body);
        return clienti.login(body.getUsername(),body.getPassword());
    }
	
	@PutMapping("/{id}")
	public Cliente replace(@PathVariable Integer id , @RequestBody Cliente body) {
		Cliente it = get(id);
		body.setCod_visitatore(it.getCod_visitatore());
		return clienti.save(body);
	}
	
	@PatchMapping("/{id}")
	public Cliente modify (@PathVariable Integer id , @RequestBody Cliente body) {
		Cliente it = get(id);
		if(body.getPassword() != null) {
			it.setPassword(body.getPassword());
		}
		if(body.getLogin() != null) {
			it.setLogin(body.getLogin());
		}
		return clienti.save(it);
	}
	
	@DeleteMapping("/{id}")
	public Cliente remove(@PathVariable Integer id , @RequestBody Cliente body) {
		Cliente us = get(id);
		clienti.delete(us);
		return us;
	}
}
