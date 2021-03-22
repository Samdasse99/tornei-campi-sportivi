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
import it.itsrizzoli.ifts2021.springsportshub.model.Slot;
import it.itsrizzoli.ifts2021.springsportshub.repository.SlotRepository;

@RestController
@CrossOrigin(origins = "*")
public class SlotController {

	@Autowired
	private SlotRepository repository;
	
	@GetMapping("/slots")
	public ResponseEntity<List<Slot>> all() {
		List<Slot> slots = repository.findAll();
		return ResponseEntity.ok(slots);
	}
	
	@PostMapping("/slots")
	public ResponseEntity<?> newSlot(@RequestBody Slot slot) {
		Slot postedSlot = repository.save(slot);
		return ResponseEntity.created(null).body(postedSlot);
	}
	
	@GetMapping("/slots/{idSlot}")
	public ResponseEntity<Slot> one(@PathVariable Integer idSlot) {
		Slot slot = repository.findById(idSlot)
				.orElseThrow(() -> new NotFoundException(idSlot));
		return ResponseEntity.ok(slot);
	}
	
	@PutMapping("/slots/{idSlot}")
	public ResponseEntity<?> replace(@PathVariable Integer idSlot, @RequestBody Slot newSlot) {
		Slot updatedSlot = repository.findById(idSlot)
				.map(slot -> {
					slot.setDataOraInizio(newSlot.getDataOraInizio());
					slot.setDataOraFine(newSlot.getDataOraFine());
					slot.setPrezzo(newSlot.getPrezzo());
					slot.setScontoPercent(newSlot.getScontoPercent());
					slot.setScontoRiscattato(newSlot.getScontoRiscattato());
					slot.setCampo(newSlot.getCampo());
					slot.setReferente(newSlot.getReferente());
					slot.setGruppo(newSlot.getGruppo());
					return repository.save(slot);
				})
				.orElseGet(() -> {
					newSlot.setIdSlot(idSlot);
					return repository.save(newSlot);
				});
		return ResponseEntity.created(null).body(updatedSlot);
	}

	@DeleteMapping("/slots/{idSlot}")
	public ResponseEntity<?> delete(@PathVariable Integer idSlot) {
		repository.deleteById(idSlot);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("campi/{idCampo}/slots")
	public ResponseEntity<List<Slot>> allInCampo(@PathVariable Integer idCampo) {
		List<Slot> slots = repository.findByCampoIdCampo(idCampo);
		return ResponseEntity.ok(slots);
	}
	
	@GetMapping("gruppi/{idGruppo}/slots")
	public ResponseEntity<List<Slot>> allInGruppo(@PathVariable Integer idGruppo) {
		List<Slot> slots = repository.findByGruppoIdGruppo(idGruppo);
		return ResponseEntity.ok(slots);
	}
	
	@GetMapping("giocatori/{email}/slots")
	public ResponseEntity<List<Slot>> allInGiocatore(@PathVariable String email) {
		List<Slot> slots = repository.findByReferenteEmail(email);
		return ResponseEntity.ok(slots);
	}
}
