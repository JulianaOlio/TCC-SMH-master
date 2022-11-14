package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.Endereco;
import com.letscodeTCCSMH.TCCSMH.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    // @Autowired
    //private CadastroUsuarioRepository cadastroUsuarioRepository;

    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
    public Endereco buscarEndereco(Endereco endereco) {
        return enderecoRepository.findByCep(endereco);
    }
    public boolean atualizarEndereco(String cep, Endereco endereco) {
             Endereco enderecoBD = enderecoRepository.findByCepString(cep);
            if (endereco != null) {
                enderecoBD.setTipoLogradouro(endereco.getTipoLogradouro());
                enderecoBD.setLogradouro(endereco.getLogradouro());
                enderecoBD.setNumero(endereco.getNumero());
                enderecoBD.setCep(endereco.getCep());
                enderecoBD.setComplemento(endereco.getComplemento());
                enderecoBD.setBairro(endereco.getBairro());
                enderecoBD.setCidade(endereco.getCidade());
                enderecoBD.setEstado(endereco.getEstado());
                enderecoRepository.save(endereco);
                return true;
            }
            return false;
        }
    public boolean excluirEndereco(String cep) {
        Endereco enderecoUsuario = enderecoRepository.findByCepString(cep);
        if (enderecoUsuario != null) {
            enderecoRepository.findByCepString(cep);
            return true;
        }
        return false;
    }
    }
