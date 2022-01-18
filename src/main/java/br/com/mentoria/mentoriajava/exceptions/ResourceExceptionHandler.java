package br.com.mentoria.mentoriajava.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ProdutoJaCadastrado.class)
    public ResponseEntity<TratativasErro> produtoCadastradoHandler (ProdutoJaCadastrado exception) {
        TratativasErro erro = new TratativasErro();
        erro.setError(exception.getMessage());
        erro.setItem("Id do produto");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(ProdutoNaoEncontrado.class)
    public ResponseEntity<TratativasErro> produtoNaoEncontradoHandler (ProdutoNaoEncontrado exception) {
        TratativasErro error = new TratativasErro();
        error.setItem("Numero da Conta");
        error.setError(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ProdutosNaoEncontrados.class)
    public ResponseEntity<TratativasErro> produtosNaoEncontradosHandler (ProdutosNaoEncontrados exception) {
        TratativasErro error = new TratativasErro();
        error.setItem("Numero da Conta");
        error.setError(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

