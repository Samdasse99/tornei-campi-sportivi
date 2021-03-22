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
import it.itsrizzoli.ifts2021.springsportshub.repository.CampoRepository;

@RestController
@CrossOrigin(origins = "*")
public class CampoController {

	@Autowired
	private CampoRepository repository;
		
	@GetMapping("/campi")
	public ResponseEntity<List<Campo>> all() {
		List<Campo> campi = repository.findAll();
		return ResponseEntity.ok(campi);
	}
	
	@PostMapping("/campi")
	public ResponseEntity<?> newCampo(@RequestBody Campo campo) {
		Campo postedCampo = repository.save(campo);
		return ResponseEntity.created(null).body(postedCampo);
	}

	@GetMapping("/campi/{idCampo}")
	public ResponseEntity<Campo> one(@PathVariable Integer idCampo) {
		Campo campo = repository.findById(idCampo)
				.orElseThrow(() -> new NotFoundException(idCampo));
		return ResponseEntity.ok(campo);
	}

	@PutMapping("campi/{idCampo}")
	public ResponseEntity<?> replace(@PathVariable Integer idCampo, @RequestBody Campo newCampo) {
		Campo updatedCampo = repository.findById(idCampo)
				.map(campo -> {
					campo.setNomeCampo(newCampo.getNomeCampo());
					campo.setCoperto(newCampo.getCoperto());
					campo.setSpogliatoi(newCampo.getSpogliatoi());
					campo.setCentroSportivo(newCampo.getCentroSportivo());
					campo.setSuperficie(newCampo.getSuperficie());
					campo.setSports(newCampo.getSports());
					campo.setSlots(newCampo.getSlots());
					return repository.save(campo);
				})
				.orElseGet(() -> {
					newCampo.setIdCampo(idCampo);
					return repository.save(newCampo);
				});
		return ResponseEntity.created(null).body(updatedCampo);
	}

	@DeleteMapping("campi/{idCampo}")
	public ResponseEntity<?> delete(@PathVariable Integer idCampo) {
		repository.deleteById(idCampo);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("centri-sportivi/{email}/campi")
	public ResponseEntity<List<Campo>> allInCentro(@PathVariable String email) {
		List<Campo> campi = repository.findByCentroSportivoEmail(email);
		return ResponseEntity.ok(campi);
	}
	
	@GetMapping("sports/{idSport}/campi")
	public ResponseEntity<List<Campo>> allInSport(@PathVariable Integer idSport) {
		List<Campo> campi = repository.findBySportsIdSport(idSport);
		return ResponseEntity.ok(campi);
	}
	
	@GetMapping("superfici/{idSuperficie}/campi")
	public ResponseEntity<List<Campo>> allInSuperficie(@PathVariable Integer idSuperficie) {
		List<Campo> campi = repository.findBySuperficieIdSuperficie(idSuperficie);
		return ResponseEntity.ok(campi);
	}
}
