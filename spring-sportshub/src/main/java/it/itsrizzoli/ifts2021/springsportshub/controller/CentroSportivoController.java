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
import it.itsrizzoli.ifts2021.springsportshub.model.CentroSportivo;
import it.itsrizzoli.ifts2021.springsportshub.repository.CentroSportivoRepository;

@RestController
public class CentroSportivoController {

	@Autowired
	private CentroSportivoRepository repository;
	
	@GetMapping("/centri-sportivi")
	public ResponseEntity<List<CentroSportivo>> all() {
		List<CentroSportivo> centriSportivi = repository.findAll();
		return ResponseEntity.ok(centriSportivi);
	}
	
	@PostMapping("/centri-sportivi")
	public ResponseEntity<?> newCentroSportivo(@RequestBody CentroSportivo centroSportivo) {
		CentroSportivo postedCentro = repository.save(centroSportivo);
		return ResponseEntity.created(null).body(postedCentro);
	}
	
	@GetMapping("/centri-sportivi/{email}")
	public ResponseEntity<CentroSportivo> one(@PathVariable String email) {
		CentroSportivo centroSportivo = repository.findById(email)
				.orElseThrow(() -> new NotFoundException(email));
		return ResponseEntity.ok(centroSportivo);
	}
	
	@PutMapping("centri-sportivi/{email}")
	public ResponseEntity<?> replace(@PathVariable String email, @RequestBody CentroSportivo newCentro) {
		CentroSportivo updatedCentro = repository.findById(email)
				.map(centro -> {
					centro.setNomeCentro(newCentro.getNomeCentro());
					centro.setpIva(newCentro.getpIva());
					centro.setNumTelefono(newCentro.getNumTelefono());
					centro.setIndirizzo(newCentro.getIndirizzo());
					centro.setCitta(newCentro.getCitta());
					centro.setSogliaCoupon(newCentro.getSogliaCoupon());
					centro.setCampi(newCentro.getCampi());
					return repository.save(centro);
				})
				.orElseGet(() -> {
					newCentro.setEmail(email);
					return repository.save(newCentro);
				});
		return ResponseEntity.created(null).body(updatedCentro);
	}

	@DeleteMapping("centri-sportivi/{email}")
	public ResponseEntity<?> delete(@PathVariable String email) {
		repository.deleteById(email);
		return ResponseEntity.noContent().build();
	}
}
