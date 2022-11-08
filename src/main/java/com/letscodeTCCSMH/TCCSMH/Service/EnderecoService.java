package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.Endereco;
import com.letscodeTCCSMH.TCCSMH.Repository.CadastroUsuarioRepository;
import com.letscodeTCCSMH.TCCSMH.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CadastroUsuarioRepository cadastroUsuarioRepository;


    public Endereco buscarEndereco(Endereco cep){
        return enderecoRepository.findAll(cep);
    }
}
