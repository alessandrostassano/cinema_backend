package it.formarete.cinemaalessandro.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Entity
public class Biglietto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cod_operazione;
	
	@ManyToOne
	@JoinColumn(name="cod_visitatore")
	private Cliente visitatore;
	
	private Integer ora_proiezione;
	
	private Date data ;
	
	private String tipo_pagamento;
	
	private Integer quantity;
	
	@OneToOne
	@JoinColumn(name="cod_film")
	private Film film;
}
