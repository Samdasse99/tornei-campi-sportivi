package it.itsrizzoli.ifts2021.springsportshub.controller;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.itsrizzoli.ifts2021.springsportshub.assembler.CentroSportivoModelAssembler;
import it.itsrizzoli.ifts2021.springsportshub.exceptions.NotFoundException;
import it.itsrizzoli.ifts2021.springsportshub.model.CentroSportivo;
import it.itsrizzoli.ifts2021.springsportshub.repository.CentroSportivoRepository;

@RestController
public class CentroSportivoController {

	@Autowired
	private CentroSportivoRepository repository;
	
	@Autowired
	private CentroSportivoModelAssembler assembler;
	
	@GetMapping("/centri-sportivi")
	public CollectionModel<EntityModel<CentroSportivo>> all() {
		List<EntityModel<CentroSportivo>> centriSportivi = repository.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		return CollectionModel.of(centriSportivi,
				linkTo(methodOn(CentroSportivoController.class).all()).withSelfRel());
	}
	
	@PostMapping("/centri-sportivi")
	public ResponseEntity<?> newCentroSportivo(@RequestBody CentroSportivo centroSportivo) {
		EntityModel<CentroSportivo> entityModel = assembler.toModel(repository.save(centroSportivo));
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}
	
	@GetMapping("/centri-sportivi/{email}")
	public EntityModel<CentroSportivo> one(@PathVariable String email) {
		CentroSportivo centroSportivo = repository.findById(email)
				.orElseThrow(() -> new NotFoundException(email));
		return assembler.toModel(centroSportivo);
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
		EntityModel<CentroSportivo> entityModel = assembler.toModel(updatedCentro);
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}

	@DeleteMapping("centri-sportivi/{email}")
	public ResponseEntity<?> delete(@PathVariable String email) {
		repository.deleteById(email);
		return ResponseEntity.noContent().build();
	}
}
