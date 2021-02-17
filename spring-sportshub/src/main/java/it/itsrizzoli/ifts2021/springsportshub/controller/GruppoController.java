package it.itsrizzoli.ifts2021.springsportshub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.itsrizzoli.ifts2021.springsportshub.exceptions.NotFoundException;
import it.itsrizzoli.ifts2021.springsportshub.model.Campo;
import it.itsrizzoli.ifts2021.springsportshub.model.Gruppo;
import it.itsrizzoli.ifts2021.springsportshub.repository.GruppoRepository;


@RestController
public class GruppoController {
	
	@Autowired
	private GruppoRepository repository;
	
	@GetMapping("/gruppi")
	public ResponseEntity<List<Gruppo>> all() {
		List<Gruppo> gruppi = repository.findAll();
		return ResponseEntity.ok(gruppi);
	}
	
	@PostMapping("/gruppi")
	public ResponseEntity<?> newGruppo(@RequestBody Gruppo gruppo) {
		Gruppo postedGruppo = repository.save(gruppo);
		return ResponseEntity.created(null).body(postedGruppo);
	}
	
	@GetMapping("/gruppi/{idGruppo}")
	public ResponseEntity<Gruppo> one(@PathVariable Integer idGruppo) {
		Gruppo gruppo = repository.findById(idGruppo)
				.orElseThrow(() -> new NotFoundException(idGruppo));
		return ResponseEntity.ok(gruppo);
	}
	
	@PutMapping("/gruppi/{idGruppo}")
	public ResponseEntity<?> replace(@PathVariable Integer idGruppo, @RequestBody Gruppo newGruppo) {
		Gruppo updatedGruppo = repository.findById(idGruppo)
				.map(gruppo -> {
					gruppo.setNomeGruppo(newGruppo.getNomeGruppo());
					gruppo.setGiocatori(newGruppo.getGiocatori());
					gruppo.setCreatore(newGruppo.getCreatore());
					gruppo.setSlots(newGruppo.getSlots());
					return repository.save(gruppo);
				})
				.orElseGet(() -> {
					newGruppo.setIdGruppo(idGruppo);
					return repository.save(newGruppo);
				});
		return ResponseEntity.created(null).body(updatedGruppo);
	}

	@DeleteMapping("/gruppi/{idGruppo}")
	public ResponseEntity<?> delete(@PathVariable Integer idGruppo) {
		repository.deleteById(idGruppo);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("giocatore/{email}/gruppi")
	public ResponseEntity<List<Gruppo>> allInGiocatore(@PathVariable String email) {
		List<Gruppo> gruppi = repository.findByGiocatoriEmail(email);
		return ResponseEntity.ok(gruppi);
	}
	
	@GetMapping("giocatore/{email}/gruppi-creati")
	public ResponseEntity<List<Gruppo>> createdByGiocatore(@PathVariable String email) {
		List<Gruppo> gruppi = repository.findByCreatoreEmail(email);
		return ResponseEntity.ok(gruppi);
	}
}
