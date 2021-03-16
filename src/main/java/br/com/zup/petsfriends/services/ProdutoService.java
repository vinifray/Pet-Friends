package br.com.zup.petsfriends.services;

import br.com.zup.petsfriends.dtos.ResumoProdutoDTO;
import br.com.zup.petsfriends.exceptions.ListaDeProdutosNaoEncontradosException;
import br.com.zup.petsfriends.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProdutoService {
    private static List<Produto> estoque = Arrays.asList(new Produto("Biscoito Canino", 22.90, 19));

    public List<Produto> pesquisarProdutosPelosNomes(List<ResumoProdutoDTO> produtos) {
        List<Produto> retornoProdutos = new ArrayList<>();
        List<ResumoProdutoDTO> produtosComErro = new ArrayList<>();

        for (ResumoProdutoDTO resumoProdutoDTO : produtos) {
            try {
                retornoProdutos.add(pesquisarProdutoPeloNome(resumoProdutoDTO));
            } catch (RuntimeException e) {
                produtosComErro.add(resumoProdutoDTO);
            }
        }

        if (!produtosComErro.isEmpty()) {
            throw new ListaDeProdutosNaoEncontradosException(
                    "Os produtos não foram encontrados", produtosComErro);
        }

        return retornoProdutos;
    }

    public Produto pesquisarProdutoPeloNome(ResumoProdutoDTO resumoProdutoDTO) {
        for (Produto produto : estoque) {
            if (produto.getNome().equalsIgnoreCase(resumoProdutoDTO.getNome())) {
                return produto;
            }
        }
        throw new RuntimeException("Produto não encontrado");
    }

    public void deletarProdutoPeloNome(String nomeDoProduto) {
        ResumoProdutoDTO resumo = new ResumoProdutoDTO();
        resumo.setNome(nomeDoProduto);

        Produto produto = pesquisarProdutoPeloNome(resumo);
        estoque.remove(produto);
    }
}
