package br.com.zup.petsfriends.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Produto {
    @NotNull(message = "O nome é um campo obrigatório")
    @NotEmpty(message =  "O nome não pode ficar vazio")
    @Min(value = 3, message = "Nome inválido com menos de 3 caracteres")
    private String nome;

    @NotNull(message = "O preço é um campo obrigatório")
    @NotEmpty(message =  "O preço não pode ficar vazio")
    private double preco;

    @NotNull(message = "A quantidade é um campo obrigatório")
    @NotEmpty(message =  "A quantidade não pode ficar vazia")
    private int quantidade;

    public Produto() {
    }

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
