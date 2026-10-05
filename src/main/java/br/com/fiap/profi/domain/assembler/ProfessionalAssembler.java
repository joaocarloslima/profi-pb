package br.com.fiap.profi.domain.assembler;

import br.com.fiap.profi.controllers.ProfessionalController;
import br.com.fiap.profi.domain.professional.Professional;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProfessionalAssembler implements RepresentationModelAssembler<Professional, EntityModel<Professional>> {

    @Override
    public EntityModel<Professional> toModel(Professional professional) {

        return EntityModel.of(
                professional,
                linkTo(methodOn(ProfessionalController.class).getProfessionalById(professional.getId())).withSelfRel(),
                linkTo(methodOn(ProfessionalController.class).getAllProfessionals()).withRel("listAll"),
                linkTo(methodOn(ProfessionalController.class).findByLocationId(professional.getLocation().getId())).withRel("nearbyProfessionals")
        );
    }
}
