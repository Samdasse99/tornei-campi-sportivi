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
import it.itsrizzoli.ifts2021.springsportshub.model.Superficie;
import it.itsrizzoli.ifts2021.springsportshub.repository.SuperficieRepository;


@RestController
@CrossOrigin(origins = "*")
public class SuperficieController {
	
	@Autowired
	private SuperficieRepository repository;
	
	@GetMapping("/superfici")
	public ResponseEntity<List<Superficie>> all() {
		List<Superficie> superfici = repository.findAll();
		return ResponseEntity.ok(superfici);
	}
	
	@PostMapping("/superfici")
	public ResponseEntity<?> newSuperficie(@RequestBody Superficie superficie) {
		Superficie postedSuperficie = repository.save(superficie);
		return ResponseEntity.created(null).body(postedSuperficie);
	}
	
	@GetMapping("/superfici/{idSuperficie}")
	public ResponseEntity<Superficie> one(@PathVariable Integer idSuperficie) {
		Superficie superficie = repository.findById(idSuperficie)
				.orElseThrow(() -> new NotFoundException(idSuperficie));
		return ResponseEntity.ok(superficie);
	}
	
	@PutMapping("/superfici/{idSuperficie}")
	public ResponseEntity<?> replace(@PathVariable Integer idSuperficie, @RequestBody Superficie newSuperficie) {
		Superficie updatedSuperficie = repository.findById(idSuperficie)
				.map(superficie -> {
					superficie.setMateriale(newSuperficie.getMateriale());
					superficie.setCampi(newSuperficie.getCampi());
					return repository.save(superficie);
				})
				.orElseGet(() -> {
					newSuperficie.setIdSuperficie(idSuperficie);
					return repository.save(newSuperficie);
				});
		return ResponseEntity.created(null).body(updatedSuperficie);
	}

	@DeleteMapping("/superfici/{idSuperficie}")
	public ResponseEntity<?> delete(@PathVariable Integer idSuperficie) {
		repository.deleteById(idSuperficie);
		return ResponseEntity.noContent().build();
	}
}
