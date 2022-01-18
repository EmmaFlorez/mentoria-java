package br.com.mentoria.mentoriajava.exceptions;

public class ProdutoNaoEncontrado extends RuntimeException{

    public ProdutoNaoEncontrado(String message, Long id){
        super(message);
    }


}
