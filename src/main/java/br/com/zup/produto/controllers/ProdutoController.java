package br.com.zup.produto.controllers;

import br.com.zup.produto.models.Produto;
import br.com.zup.produto.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionarProduto(@RequestBody Produto produto){
       return produtoService.adicionarProduto(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoService.pegarProdutos();
    }

    @GetMapping("{nome}/")
    public Produto pesquisarProdutoPeloNome(@PathVariable String nome){
        try{
            return produtoService.pesquisarProduto(nome);
        }catch (RuntimeException erro){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, erro.getMessage());
        }
    }

    @DeleteMapping("{nome}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable String nome){
        try {
            produtoService.deletarProduto(nome);
        }catch (RuntimeException erro){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, erro.getMessage());
        }
    }
}
