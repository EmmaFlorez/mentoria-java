package br.com.mentoria.mentoriajava.service;

import br.com.mentoria.mentoriajava.exceptions.ProdutoJaCadastrado;
import br.com.mentoria.mentoriajava.exceptions.ProdutoNaoEncontrado;
import br.com.mentoria.mentoriajava.exceptions.ProdutosNaoEncontrados;
import br.com.mentoria.mentoriajava.model.Categoria;
import br.com.mentoria.mentoriajava.model.Produto;
import br.com.mentoria.mentoriajava.model.dto.request.CategoriaRequestDTO;
import br.com.mentoria.mentoriajava.model.dto.request.ProdutoRequestDTO;
import br.com.mentoria.mentoriajava.model.dto.response.CategoriaResponseDTO;
import br.com.mentoria.mentoriajava.model.dto.response.ProdutoResponseDTO;
import br.com.mentoria.mentoriajava.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    public ProdutoResponseDTO salvarProduto(ProdutoRequestDTO produto){
        Produto prod = ProdutoRequestDTO.conversor(produto);
        produtoRepository.save(prod);
        return new ProdutoResponseDTO(prod);
    }

    public List<ProdutoResponseDTO> buscarTodosProdutos(){
        List<Produto> teste = produtoRepository.findAll();
        if (teste.isEmpty()) {
            throw new ProdutosNaoEncontrados("Produto já cadastrado no sistema");
        } else {
            return ProdutoResponseDTO.converterLista(produtoRepository.findAll());
        }
    }

    public ProdutoResponseDTO buscarUmProduto(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            throw new ProdutoNaoEncontrado("Produto não encontrado no sistema", id);
        }
        return new ProdutoResponseDTO(produtoRepository.findById(id).get());
    }


    public ProdutoResponseDTO atualizarProdutos(Long id, ProdutoRequestDTO prod){
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if(produtoExistente.isEmpty()){
            throw new ProdutoNaoEncontrado("Produto não encontrado no sistema", id);
        }
        Produto produtoAtualizado = ProdutoRequestDTO.conversor(prod);
        produtoAtualizado.setId(produtoExistente.get().getId());
        return new ProdutoResponseDTO(produtoRepository.save(produtoAtualizado));
    }

    public void deletarProduto(Long id){
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if(produtoExistente.isEmpty()){
            throw new ProdutoNaoEncontrado("Produto não encontrado no sistema", id);
        }
        produtoRepository.deleteById(id);
    }
}