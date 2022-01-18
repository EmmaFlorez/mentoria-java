package br.com.mentoria.mentoriajava.model.dto.response;

import br.com.mentoria.mentoriajava.model.Categoria;
import br.com.mentoria.mentoriajava.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private double preco;
    private Categoria categoria;
    public ProdutoResponseDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.categoria = produto.getCategoria();
    }

    public ProdutoResponseDTO(Optional<Produto> produto) {
        this.id = produto.get().getId();
        this.nome = produto.get().getNome();
        this.preco = produto.get().getPreco();
        this.categoria = produto.get().getCategoria();
    }

    public static List<ProdutoResponseDTO> converterLista (List<Produto> produtoList){
        return produtoList.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
    }
}
