package br.com.mentoria.mentoriajava.repository;

import br.com.mentoria.mentoriajava.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
