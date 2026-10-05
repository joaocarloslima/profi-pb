package br.com.fiap.profi.repositories;

import br.com.fiap.profi.domain.professional.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    List<Professional> findByLocationId(Long locationId);
}
