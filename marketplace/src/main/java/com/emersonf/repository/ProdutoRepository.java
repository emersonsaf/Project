package com.emersonf.repository;

import com.emersonf.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAll();

    Produto findById(long id);

    Produto findByNome(String nome);


}
