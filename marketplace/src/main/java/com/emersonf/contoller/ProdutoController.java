package com.emersonf.contoller;

import com.emersonf.model.Fornecedor;
import com.emersonf.model.Produto;
import com.emersonf.repository.FornecedorRepository;
import com.emersonf.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @RequestMapping("")
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @RequestMapping(value = "novo", method = RequestMethod.POST)
    public Produto Post(@Valid @RequestBody Produto novoProduto){

        Fornecedor novo = fornecedorRepository.findById(3);

        novoProduto.setDeleted("0");
        novoProduto.setDatainc(new Date());
        produtoRepository.save(novoProduto);

        novo.getProdutos().add(novoProduto);
        fornecedorRepository.save(novo);

        return novoProduto;
    }
}
