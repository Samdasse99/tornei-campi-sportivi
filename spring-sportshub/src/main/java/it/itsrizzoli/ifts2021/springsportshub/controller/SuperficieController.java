package it.itsrizzoli.ifts2021.springsportshub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.itsrizzoli.ifts2021.springsportshub.model.Superficie;
import it.itsrizzoli.ifts2021.springsportshub.repository.SuperficieRepository;


@RestController
public class SuperficieController {
	
	@Autowired
	private SuperficieRepository repository;
	
	@GetMapping("/superfici")
	public List<Superficie> allsuperfici() {
		return repository.findAll();
	}
}
