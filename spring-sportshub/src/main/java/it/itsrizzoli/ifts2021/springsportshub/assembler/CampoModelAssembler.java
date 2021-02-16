package it.itsrizzoli.ifts2021.springsportshub.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import it.itsrizzoli.ifts2021.springsportshub.controller.CampoController;
import it.itsrizzoli.ifts2021.springsportshub.model.Campo;

@Component
public class CampoModelAssembler implements RepresentationModelAssembler<Campo, EntityModel<Campo>> {

	@Override
	public EntityModel<Campo> toModel(Campo campo) {
		return EntityModel.of(campo,
				linkTo(methodOn(CampoController.class).one(campo.getIdCampo())).withSelfRel(),
				linkTo(methodOn(CampoController.class).all()).withRel("campi"));
	}
}
