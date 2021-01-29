package it.itsrizzoli.ifts2021.springsportshub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.itsrizzoli.ifts2021.springsportshub.model.Slot;
import it.itsrizzoli.ifts2021.springsportshub.repository.SlotRepository;

@RestController
public class SlotController {

	@Autowired
	private SlotRepository repository;
	
	@GetMapping("/slots")
	public List<Slot> allSlots() {
		return repository.findAll();
	}
}
