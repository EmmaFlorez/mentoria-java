package br.com.mentoria.mentoriajava.exceptions;

public class ProdutoJaCadastrado extends RuntimeException{

    public ProdutoJaCadastrado(String message, Long id){
        super(message);
    }
}
