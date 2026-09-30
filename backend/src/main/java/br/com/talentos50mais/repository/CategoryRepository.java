package br.com.talentos50mais.repository;

import br.com.talentos50mais.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}