package it.itsrizzoli.ifts2021.springsportshub.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import it.itsrizzoli.ifts2021.springsportshub.controller.CentroSportivoController;
import it.itsrizzoli.ifts2021.springsportshub.model.CentroSportivo;

@Component
public class CentroSportivoModelAssembler implements RepresentationModelAssembler<CentroSportivo, EntityModel<CentroSportivo>> {

	@Override
	public EntityModel<CentroSportivo> toModel(CentroSportivo centroSportivo) {
		return EntityModel.of(centroSportivo,
				linkTo(methodOn(CentroSportivoController.class).one(centroSportivo.getEmail())).withSelfRel(),
				linkTo(methodOn(CentroSportivoController.class).all()).withRel("centri-sportivi"));
	}

}
