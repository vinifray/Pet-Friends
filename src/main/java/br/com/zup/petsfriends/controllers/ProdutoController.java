package br.com.zup.petsfriends.controllers;

import br.com.zup.petsfriends.dtos.CompraDTO;
import br.com.zup.petsfriends.models.Produto;
import br.com.zup.petsfriends.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Produto> realizarCompra(@RequestBody CompraDTO compraDTO){
        System.out.println(compraDTO.getProdutos());
        return produtoService.pesquisarProdutosPelosNomes(compraDTO.getProdutos());
    }

    @DeleteMapping("{nomeDoProduto}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable String nomeDoProduto) {
        produtoService.deletarProdutoPeloNome(nomeDoProduto);
    }
}
