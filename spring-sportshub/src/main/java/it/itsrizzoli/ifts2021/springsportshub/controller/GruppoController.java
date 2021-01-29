package it.itsrizzoli.ifts2021.springsportshub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.itsrizzoli.ifts2021.springsportshub.model.Gruppo;
import it.itsrizzoli.ifts2021.springsportshub.repository.GruppoRepository;


@RestController
public class GruppoController {
	
	@Autowired
	private GruppoRepository repository;
	
	@GetMapping("/gruppi")
	public List<Gruppo> allgruppi() {
		return repository.findAll();
	}

}
