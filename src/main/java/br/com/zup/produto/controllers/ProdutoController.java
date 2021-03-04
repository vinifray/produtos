package br.com.zup.produto.controllers;

import br.com.zup.produto.models.Produto;
import br.com.zup.produto.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto){
       produtoService.adicionarProduto(produto);
       return produto;
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoService.pegarProdutos();
    }
}
