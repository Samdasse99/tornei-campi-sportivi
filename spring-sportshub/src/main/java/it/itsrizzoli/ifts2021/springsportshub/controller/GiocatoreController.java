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
import it.itsrizzoli.ifts2021.springsportshub.model.Giocatore;
import it.itsrizzoli.ifts2021.springsportshub.repository.GiocatoreRepository;


@RestController
@CrossOrigin(origins = "*")
public class GiocatoreController {
	
	@Autowired
	private GiocatoreRepository repository;
	
	@GetMapping("/giocatori")
	public ResponseEntity<List<Giocatore>> all() {
		List<Giocatore> giocatori = repository.findAll();
		return ResponseEntity.ok(giocatori);
	}
	
	@PostMapping("/giocatori")
	public ResponseEntity<?> newGiocatore(@RequestBody Giocatore giocatore) {
		Giocatore postedGiocatore = repository.save(giocatore);
		return ResponseEntity.created(null).body(postedGiocatore);
	}
	
	@GetMapping("/giocatori/{email}")
	public ResponseEntity<Giocatore> one(@PathVariable String email) {
		Giocatore giocatore = repository.findById(email)
				.orElseThrow(() -> new NotFoundException(email));
		return ResponseEntity.ok(giocatore);
	}
	
	@PutMapping("/giocatori/{email}")
	public ResponseEntity<?> replace(@PathVariable String email, @RequestBody Giocatore newGiocatore) {
		Giocatore updatedGiocatore = repository.findById(email)
				.map(giocatore -> {
					giocatore.setPassword(newGiocatore.getPassword());
					giocatore.setNome(newGiocatore.getNome());
					giocatore.setCognome(newGiocatore.getCognome());
					giocatore.setNumeroTelefono(newGiocatore.getNumeroTelefono());
					giocatore.setIndirizzo(newGiocatore.getIndirizzo());
					giocatore.setCitta(newGiocatore.getCitta());
					giocatore.setGruppi(newGiocatore.getGruppi());
					giocatore.setGruppiCreati(newGiocatore.getGruppiCreati());
					giocatore.setSlots(newGiocatore.getSlots());
					return repository.save(giocatore);
				})
				.orElseGet(() -> {
					newGiocatore.setEmail(email);
					return repository.save(newGiocatore);
				});
		return ResponseEntity.created(null).body(updatedGiocatore);
	}

	@DeleteMapping("/giocatori/{email}")
	public ResponseEntity<?> delete(@PathVariable String email) {
		repository.deleteById(email);
		return ResponseEntity.noContent().build();
	}
}
