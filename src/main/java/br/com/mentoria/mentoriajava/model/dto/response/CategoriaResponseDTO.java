package br.com.mentoria.mentoriajava.model.dto.response;

import br.com.mentoria.mentoriajava.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    public CategoriaResponseDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }

    public CategoriaResponseDTO(Optional<Categoria> categoria) {
        this.id = categoria.get().getId();
        this.nome = categoria.get().getNome();
        this.descricao = categoria.get().getDescricao();
    }

    public static List<CategoriaResponseDTO> converterLista (List<Categoria> categoriaList){
        return categoriaList.stream().map(CategoriaResponseDTO::new).collect(Collectors.toList());
    }
}