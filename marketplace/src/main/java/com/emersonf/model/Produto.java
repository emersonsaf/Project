package com.emersonf.model;

import com.emersonf.utils.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "produtos")
public class Produto extends GenericEntity {

    @NotNull(message = "This field cannot be null")
    @NotEmpty(message = "This Field cannot be empty!")
    private String nome;

    @NotNull(message = "This field cannot be null")
    @NotEmpty(message = "This Field cannot be empty!")
    private Double preco;

    private Date datainc;

    private String deleted;
    
    @ManyToMany(mappedBy = "produtos")
    private List<Fornecedor> listaFornecedor;

    public List<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Date getDatainc() {
        return datainc;
    }

    public void setDatainc(Date datainc) {
        this.datainc = datainc;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
