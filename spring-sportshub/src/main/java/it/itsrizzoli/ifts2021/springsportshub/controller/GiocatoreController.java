package it.itsrizzoli.ifts2021.springsportshub.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.itsrizzoli.ifts2021.springsportshub.model.Giocatore;
import it.itsrizzoli.ifts2021.springsportshub.repository.GiocatoreRepository;


@RestController
public class GiocatoreController {
	
	@Autowired
	private GiocatoreRepository repository;
	
	@GetMapping("/giocatori")
	public List<Giocatore> allGiocatori() {
		return repository.findAll();
	}

}
