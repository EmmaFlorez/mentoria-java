package br.com.mentoria.mentoriajava.model.dto.request;

import br.com.mentoria.mentoriajava.model.Categoria;
import br.com.mentoria.mentoriajava.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {

    private String nome;
    private double preco;
    private Categoria categoria;
    public static Produto conversor(ProdutoRequestDTO produtoRequestDTO){
        Produto produto = new Produto();
        produto.setNome(produtoRequestDTO.getNome());
        produto.setPreco(produtoRequestDTO.getPreco());
        produto.setCategoria(produtoRequestDTO.getCategoria());
        return produto;
    }

}
