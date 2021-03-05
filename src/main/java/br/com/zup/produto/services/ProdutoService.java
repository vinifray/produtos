package br.com.zup.produto.services;

import br.com.zup.produto.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private static List<Produto> produtos = new ArrayList<>();

    public Produto adicionarProduto(Produto produto){
        try{
            Produto objProduto = pesquisarProduto(produto);
            int resultado = objProduto.getQuantidade() + produto.getQuantidade();
            objProduto.setQuantidade(resultado);
            return objProduto;

        }catch (RuntimeException erro){

            produtos.add(produto);
            return produto;
        }
    }

    public List<Produto> pegarProdutos(){
        return produtos;
    }

    public Produto pesquisarProduto(Produto produto){
        return pesquisarProduto(produto.getNome());
    }

    public Produto pesquisarProduto(String nome){
        for (Produto objProduto : produtos){
            if (objProduto.getNome().equalsIgnoreCase(nome)){
                return objProduto;
            }
        }
        throw new RuntimeException("Produto não encontrado");
    }

    public void deletarProduto(String nome){
        Produto produto = pesquisarProduto(nome);
        produtos.remove(produto);
    }
}
