package br.com.zup.petsfriends.controllers;

import br.com.zup.petsfriends.dtos.CompraDTO;
import br.com.zup.petsfriends.models.Produto;
import br.com.zup.petsfriends.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public List<Produto> realizarCompra(@RequestBody CompraDTO compraDTO){
        System.out.println(compraDTO.getProdutos());
        return produtoService.pesquisarProdutosPelosNomes(compraDTO.getProdutos());
    }

    @GetMapping("{nome}/")
    public Produto pesquisarProdutoPeloNome(@PathVariable String nome) {
        try {
            Produto produto = produtoService.pesquisarProdutoPeloNome(nome);
            return produto;
        } catch (RuntimeException error) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error.getMessage());
        }
    }
}
