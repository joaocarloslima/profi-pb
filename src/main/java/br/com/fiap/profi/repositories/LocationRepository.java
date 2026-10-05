package br.com.fiap.profi.repositories;

import br.com.fiap.profi.domain.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
