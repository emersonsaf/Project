package com.emersonf.model;

import com.emersonf.utils.GenericEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "fornecedores")
public class Fornecedor extends GenericEntity {

    private String nome;

    private String nomeFantasia;

    @Column(length = 11,nullable = false)
    private String cnpj;

    private String deleted;

    private Date datainc;

    @JsonBackReference
    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "fornecedor_produto", joinColumns = { @JoinColumn(name = "fornecedor_id") }, inverseJoinColumns = {
            @JoinColumn(name = "produto_id") })
    private List<Produto> produtos ;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Date getDatainc() {
        return datainc;
    }

    public void setDatainc(Date datainc) {
        this.datainc = datainc;
    }
}
