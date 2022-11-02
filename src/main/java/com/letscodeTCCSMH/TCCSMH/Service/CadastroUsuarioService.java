package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Repository.CadastroUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroUsuarioService {

    @Autowired
    private CadastroUsuarioRepository cadastroUsuarioRepository;

    public void salvarCadastroUsuario(CadastroUsuario cadastroUsuario) {
       cadastroUsuarioRepository.save();
    }

    public CadastroUsuario buscarCadastroUsuario(String codigoFuncional) {
        return cadastroUsuarioRepository.findBycodigoFuncional(codigoFuncional);
    }

    public boolean atualizarCadastroUsuario(String codigoFuncional,CadastroUsuario cadastroUsuario) {
        CadastroUsuario cadastroUsuarioBD = cadastroUsuarioRepository.findBycodigoFuncional(codigoFuncional);
        if (cadastroUsuario != null) {
            cadastroUsuarioBD.setNomeCompleto(cadastroUsuario.getNomeCompleto());
            cadastroUsuarioBD.setEndereco(cadastroUsuario.getEndereco());
            cadastroUsuarioRepository.save();
            return true;
        }
        return false;
    }

    public boolean excluirCadastroUsuario(String codigoFuncional) {
        CadastroUsuario cadastroUsuario = cadastroUsuarioRepository.findBycodigoFuncional(codigoFuncional);
        if (cadastroUsuario != null) {
            cadastroUsuarioRepository.delete();
            return true;
        }
        return false;
    }
    }


