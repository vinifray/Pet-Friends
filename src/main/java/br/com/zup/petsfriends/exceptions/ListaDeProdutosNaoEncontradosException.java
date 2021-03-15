package br.com.zup.petsfriends.exceptions;

import br.com.zup.petsfriends.dtos.ResumoProdutoDTO;

import java.util.List;

public class ListaDeProdutosNaoEncontradosException extends RuntimeException {
    private List<ResumoProdutoDTO> produtos;

    public ListaDeProdutosNaoEncontradosException(String message, List<ResumoProdutoDTO> produtos) {
        super(message);
        this.produtos = produtos;
    }

    public List<ResumoProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ResumoProdutoDTO> produtos) {
        this.produtos = produtos;
    }
}
