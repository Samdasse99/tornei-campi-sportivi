	package it.itsrizzoli.ifts2021.springsportshub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
