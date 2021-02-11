	package it.itsrizzoli.ifts2021.springsportshub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.itsrizzoli.ifts2021.springsportshub.exceptions.NotFoundException;
import it.itsrizzoli.ifts2021.springsportshub.model.Campo;
import it.itsrizzoli.ifts2021.springsportshub.repository.CampoRepository;

@RestController
public class CampoController {

	@Autowired
	private CampoRepository repository;
	
	@GetMapping("/campi")
	public List<Campo> allCampi() {
		return repository.findAll();
	}
	
	@GetMapping("/campi/{idCampo}")
	public Campo byId(@PathVariable Integer idCampo) {
		return repository.findById(idCampo).orElseThrow(() -> new NotFoundException(idCampo));
	}
}
