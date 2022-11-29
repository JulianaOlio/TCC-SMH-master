package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Repository.CadastroUsuarioRepository;
import com.letscodeTCCSMH.TCCSMH.dto.AlterarUsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroUsuarioService {
    @Autowired
    private CadastroUsuarioRepository cadastroUsuarioRepository;

    public Object salvarCadastroUsuario(CadastroUsuario cadastroUsuario) {

        CadastroUsuario cadastroDB = new CadastroUsuario();

            if (cadastroDB.getLoginEmail() != cadastroUsuario.getLoginEmail()) {
                return cadastroUsuarioRepository.save(cadastroUsuario);
            }

        return false;
    }

     public CadastroUsuario buscarCadastroPorNome(String nomeCompleto) {
        return cadastroUsuarioRepository.findByNomeCompleto(nomeCompleto);
    }
    public CadastroUsuario buscarCadastroPorEmail(String loginEmail) {
        return cadastroUsuarioRepository.findByLoginEmail(loginEmail);
    }

    public boolean atualizarCadastroUsuario(String loginEmail, AlterarUsuarioDto dto) {
        Boolean alterado = false;

        CadastroUsuario cadastroUsuarioBD = cadastroUsuarioRepository.findByLoginEmail(loginEmail);
        if(dto.getNomeCompleto() != null){
            alterado = true;
            cadastroUsuarioBD.setNomeCompleto(dto.getNomeCompleto());
        }
        if(dto.getEndereco() != null) {
            alterado = true;
            cadastroUsuarioBD.setEndereco(dto.getEndereco());
        }
        if(dto.getTelefone() != null) {
            alterado = true;
            cadastroUsuarioBD.setTelefone(dto.getTelefone());
        }
        cadastroUsuarioRepository.save(cadastroUsuarioBD);
        return alterado;
    }

    public boolean excluirCadastroUsuario(String nomeCompleto) {
        CadastroUsuario cadastroUsuario = cadastroUsuarioRepository.findByNomeCompleto(nomeCompleto);
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
