package br.com.mentoria.mentoriajava.model.dto.request;

import br.com.mentoria.mentoriajava.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequestDTO {

    private String nome;
    private String descricao;
    public static Categoria conversor(CategoriaRequestDTO categoriaRequestDTO){
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaRequestDTO.getNome());
        categoria.setDescricao(categoriaRequestDTO.getDescricao());
        return categoria;
    }
}
