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
public class Cinema {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cod_cinema;
	
	private String name;
	
	private String address;
	
	private String city;
	
	private String province;
	
	private String telephone;
	
	private Integer maxVisitors;
	
	
	
	

}
