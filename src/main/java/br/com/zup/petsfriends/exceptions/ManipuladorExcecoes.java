package br.com.zup.petsfriends.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ManipuladorExcecoes extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ListaDeProdutosNaoEncontradosException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro manipuladorDeProdutosNaoEncontrados(ListaDeProdutosNaoEncontradosException exception){
        MensagemDeErro mensagemDeErro = new MensagemDeErro(exception.getMessage(),
                exception.getProdutos());

        return mensagemDeErro;
    }

}
