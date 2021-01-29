package it.itsrizzoli.ifts2021.springsportshub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.itsrizzoli.ifts2021.springsportshub.model.Sport;
import it.itsrizzoli.ifts2021.springsportshub.repository.SportRepository;

@RestController
public class SportController {

	@Autowired
	private SportRepository repository;
	
	@GetMapping("/sports")
	public List<Sport> allSports() {
		return repository.findAll();
	}
}
