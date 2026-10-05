package br.com.fiap.profi.repositories;

import br.com.fiap.profi.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
