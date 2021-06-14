package com.emersonf.repository;

import com.emersonf.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    List<Fornecedor> findAll();

    Fornecedor findById(long id);
}
