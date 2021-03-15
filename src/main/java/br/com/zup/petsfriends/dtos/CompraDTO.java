package br.com.zup.petsfriends.dtos;

import java.util.List;

public class CompraDTO {
    private String email;
    private List<ResumoProdutoDTO> produtos;

    public CompraDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ResumoProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ResumoProdutoDTO> produtos) {
        this.produtos = produtos;
    }
}
