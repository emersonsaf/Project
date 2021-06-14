package com.emersonf.contoller;

import com.emersonf.model.Fornecedor;
import com.emersonf.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @RequestMapping("")
    public List<Fornecedor> listarFornecedores(){
        return fornecedorRepository.findAll();
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public Fornecedor Post(@Valid @RequestBody Fornecedor novoFornecedor){
        novoFornecedor.setDeleted("0");
        novoFornecedor.setDatainc(new Date());

        return fornecedorRepository.save(novoFornecedor);
    }

}
