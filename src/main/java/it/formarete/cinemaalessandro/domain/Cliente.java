package it.formarete.cinemaalessandro.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cod_visitatore;
	
	private String surname;
	
	private String name;
	
	private String telephone;
	
	private String email;
	
	private String login;
	
	private String password;
	
}
