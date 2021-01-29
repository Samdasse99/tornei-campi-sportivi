package it.itsrizzoli.ifts2021.springsportshub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.itsrizzoli.ifts2021.springsportshub.model.CentroSportivo;
import it.itsrizzoli.ifts2021.springsportshub.repository.CentroSportivoRepository;

@RestController
public class CentroSportivoController {

	@Autowired
	private CentroSportivoRepository repository;
	
	@GetMapping("/centri-sportivi")
	public List<CentroSportivo> allCentriSportivi() {
		return repository.findAll();
	}
}
