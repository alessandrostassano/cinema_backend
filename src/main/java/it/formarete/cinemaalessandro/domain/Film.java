package it.formarete.cinemaalessandro.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Entity
public class Film {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cod_film;
	
	private String title ; 
	
	private Date startDate;
	
	private Date endDate;
	
	private Double price;
	
	@OneToOne
	@JoinColumn(name="cod_cinema")
	private Cinema cinema;
}
