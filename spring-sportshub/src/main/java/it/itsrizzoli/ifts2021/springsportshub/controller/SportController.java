package it.itsrizzoli.ifts2021.springsportshub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.itsrizzoli.ifts2021.springsportshub.exceptions.NotFoundException;
import it.itsrizzoli.ifts2021.springsportshub.model.Campo;
import it.itsrizzoli.ifts2021.springsportshub.model.Sport;
import it.itsrizzoli.ifts2021.springsportshub.repository.SportRepository;

@RestController
@CrossOrigin(origins = "*")
public class SportController {

	@Autowired
	private SportRepository repository;
	
	@GetMapping("/sports")
	public ResponseEntity<List<Sport>> all() {
		List<Sport> sports = repository.findAll();
		return ResponseEntity.ok(sports);
	}
	
	@PostMapping("/sports")
	public ResponseEntity<?> newSport(@RequestBody Sport sport) {
		Sport postedSport = repository.save(sport);
		return ResponseEntity.created(null).body(postedSport);
	}
	
	@GetMapping("/sports/{idSport}")
	public ResponseEntity<Sport> one(@PathVariable Integer idSport) {
		Sport sport = repository.findById(idSport)
				.orElseThrow(() -> new NotFoundException(idSport));
		return ResponseEntity.ok(sport);
	}
	
	@PutMapping("/sports/{idSport}")
	public ResponseEntity<?> replace(@PathVariable Integer idSport, @RequestBody Sport newSport) {
		Sport updatedSport = repository.findById(idSport)
				.map(sport -> {
					sport.setNomeSport(newSport.getNomeSport());
					sport.setCampi(newSport.getCampi());
					return repository.save(sport);
				})
				.orElseGet(() -> {
					newSport.setIdSport(idSport);
					return repository.save(newSport);
				});
		return ResponseEntity.created(null).body(updatedSport);
	}

	@DeleteMapping("/sports/{idSport}")
	public ResponseEntity<?> delete(@PathVariable Integer idSport) {
		repository.deleteById(idSport);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/centri-sportivi/{email}/sports")
	public ResponseEntity<List<Sport>> allInCentro(@PathVariable String email) {
		List<Sport> sports = repository.findByCampiCentroSportivoEmail(email);
		return ResponseEntity.ok(sports);
	}
}
