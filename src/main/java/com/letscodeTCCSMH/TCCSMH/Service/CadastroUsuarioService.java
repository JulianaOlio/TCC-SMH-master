package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Repository.CadastroUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroUsuarioService {

    @Autowired
    private CadastroUsuarioRepository cadastroUsuarioRepository;

    public void salvarCadastroUsuario(CadastroUsuario cadastroUsuario) {
        cadastroUsuarioRepository.save();
    }

    public CadastroUsuario buscarCadastroPorNome(String nomeCompleto){
        return cadastroUsuarioRepository.findAll(nomeCompleto);

    }

    public CadastroUsuario buscarCadastroUsuario(String id_Email) {
        return cadastroUsuarioRepository.findByid_Email(id_Email);
    }

    public boolean atualizarCadastroUsuario(String id_Email,CadastroUsuario cadastroUsuario) {
        CadastroUsuario cadastroUsuarioBD = cadastroUsuarioRepository.findByid_Email(id_Email);
        if (cadastroUsuario != null) {
            cadastroUsuarioBD.setNomeCompleto(cadastroUsuario.getNomeCompleto());
            cadastroUsuarioBD.setCodigoFuncional(cadastroUsuario.getCodigoFuncional());
            cadastroUsuarioBD.setEndereco(cadastroUsuario.getEndereco());
            cadastroUsuarioBD.setTelefone(cadastroUsuario.getTelefone());
            cadastroUsuarioRepository.save();
            return true;
        }
        return false;
    }

    public boolean excluirCadastroUsuario(String id_Email) {
        CadastroUsuario cadastroUsuario = cadastroUsuarioRepository.findBycodigoFuncional(id_Email);
        if (cadastroUsuario != null) {
            cadastroUsuarioRepository.delete();
            return true;
        }
        return false;
    }

    public List<CadastroUsuarioRepository> listarCadastroUsuarios(String nomeCompleto) {
        if (nomeCompleto != null) {
            return cadastroUsuarioRepository.findBynomeCompleto();
        } else {
           return cadastroUsuarioRepository.findAll();
        }
    }
    }


