package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Repository.CadastroUsuarioRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.List;
@Service
public class CadastroUsuarioService {
    @Autowired
    private CadastroUsuarioRepository cadastroUsuarioRepository;

    public CadastroUsuario salvarCadastroUsuario(CadastroUsuario cadastroUsuario) {
        return cadastroUsuarioRepository.save(cadastroUsuario);
    }

     public CadastroUsuario buscarCadastroPorNome(String nomeCompleto) {
        return cadastroUsuarioRepository.findByNomeCompleto(nomeCompleto);
    }
    public CadastroUsuario buscarCadastroPorEmail(String loginEmail) {
        return cadastroUsuarioRepository.findByLoginEmail(loginEmail);
    }

    public boolean atualizarCadastroUsuario(String loginEmail, CadastroUsuario cadastroUsuario) {
        CadastroUsuario cadastroUsuarioBD = cadastroUsuarioRepository.findByLoginEmail(loginEmail);
        if (cadastroUsuario != null) {
            cadastroUsuarioBD.setNomeCompleto(cadastroUsuario.getNomeCompleto());
            cadastroUsuarioBD.setCodigoFuncional(cadastroUsuario.getCodigoFuncional());
            cadastroUsuarioBD.setEndereco(cadastroUsuario.getEndereco());
            cadastroUsuarioBD.setTelefone(cadastroUsuario.getTelefone());
            cadastroUsuarioRepository.save(cadastroUsuario);
            return true;
        }
        return false;
    }

    public boolean excluirCadastroUsuario(String loginEmail) {
        CadastroUsuario cadastroUsuario = cadastroUsuarioRepository.findBycodigoFuncional(loginEmail);
        if (cadastroUsuario != null) {
            cadastroUsuarioRepository.delete(cadastroUsuario);
            return true;
        }
        return false;
    }

    public List<CadastroUsuario> listarCadastroUsuarios(String nomeCompleto) {
        if (nomeCompleto != null) {
            return cadastroUsuarioRepository.findAll();
        } else {
            return (List<CadastroUsuario>) cadastroUsuarioRepository.findAll();
        }
    }
}
