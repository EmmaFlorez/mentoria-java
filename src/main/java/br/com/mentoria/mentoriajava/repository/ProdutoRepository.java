package br.com.mentoria.mentoriajava.repository;

import br.com.mentoria.mentoriajava.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
