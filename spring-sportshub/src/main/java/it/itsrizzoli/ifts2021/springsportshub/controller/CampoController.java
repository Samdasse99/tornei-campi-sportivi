	package it.itsrizzoli.ifts2021.springsportshub.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

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

import it.itsrizzoli.ifts2021.springsportshub.assembler.CampoModelAssembler;
import it.itsrizzoli.ifts2021.springsportshub.exceptions.NotFoundException;
import it.itsrizzoli.ifts2021.springsportshub.model.Campo;
import it.itsrizzoli.ifts2021.springsportshub.repository.CampoRepository;

@RestController
public class CampoController {

	@Autowired
	private CampoRepository repository;
	
	@Autowired
	private CampoModelAssembler assembler;
	
	@GetMapping("/campi")
	public ResponseEntity<CollectionModel<EntityModel<Campo>>> all() {
		List<EntityModel<Campo>> campi = repository.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		return ResponseEntity.ok(CollectionModel.of(campi,
				linkTo(methodOn(CampoController.class).all()).withSelfRel()));
	}
	
	@PostMapping("/campi")
	public ResponseEntity<?> newCampo(@RequestBody Campo campo) {
		EntityModel<Campo> entityModel = assembler.toModel(repository.save(campo));
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}

	@GetMapping("/campi/{idCampo}")
	public ResponseEntity<EntityModel<Campo>> one(@PathVariable Integer idCampo) {
		Campo campo = repository.findById(idCampo)
				.orElseThrow(() -> new NotFoundException(idCampo));
		return ResponseEntity.ok(assembler.toModel(campo));
	}

	@PutMapping("campi/{idCampo}")
	public ResponseEntity<?> replace(@PathVariable Integer idCampo, @RequestBody Campo newCampo) {
		Campo updatedCampo = repository.findById(idCampo)
				.map(campo -> {
					campo.setCoperto(newCampo.getCoperto());
					campo.setSpogliatoi(newCampo.getSpogliatoi());
					campo.setCentroSportivo(newCampo.getCentroSportivo());
					campo.setSuperficie(newCampo.getSuperficie());
					campo.setSports(newCampo.getSports());
					campo.setSlots(newCampo.getSlots());
					return repository.save(campo);
				})
				.orElseGet(() -> {
					newCampo.setIdCampo(idCampo);;
					return repository.save(newCampo);
				});
		EntityModel<Campo> entityModel = assembler.toModel(updatedCampo);
		return ResponseEntity
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
				.body(entityModel);
	}

	@DeleteMapping("campi/{idCampo}")
	public ResponseEntity<?> delete(@PathVariable Integer idCampo) {
		repository.deleteById(idCampo);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("centri-sportivi/{email}/campi")
	public ResponseEntity<CollectionModel<EntityModel<Campo>>> allInCentro(@PathVariable String email) {
		List<EntityModel<Campo>> campi = repository.findByCentroSportivoId(email).stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		return ResponseEntity.ok(CollectionModel.of(campi,
				linkTo(methodOn(CampoController.class).allInCentro(email)).withSelfRel()));
	}
}
