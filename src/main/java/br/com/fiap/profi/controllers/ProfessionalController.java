package br.com.fiap.profi.controllers;

import br.com.fiap.profi.domain.assembler.ProfessionalAssembler;
import br.com.fiap.profi.domain.professional.Professional;
import br.com.fiap.profi.repositories.ProfessionalRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/professionals")
public class ProfessionalController {

    private final ProfessionalRepository professionalRepository;
    private final ProfessionalAssembler professionalAssembler;

    public ProfessionalController(ProfessionalRepository professionalRepository, ProfessionalAssembler professionalAssembler) {
        this.professionalRepository = professionalRepository;
        this.professionalAssembler = professionalAssembler;
    }

    @GetMapping
    public List<EntityModel<Professional>> getAllProfessionals() {
        return professionalRepository.findAll().stream()
                .map(professionalAssembler::toModel)
                .toList();
    }

    @GetMapping("{id}")
    public EntityModel<Professional> getProfessionalById(@PathVariable Long id) {
        var professional = professionalRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Professional not found with id: " + id)
        );

        return professionalAssembler.toModel(professional);

    }

    @GetMapping("/location/{locationId}")
    public List<Professional> findByLocationId(@PathVariable Long locationId){
        return professionalRepository.findByLocationId(locationId);
    }

}
