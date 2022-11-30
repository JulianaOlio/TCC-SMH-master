package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.PerfilAcesso;
import com.letscodeTCCSMH.TCCSMH.Repository.PerfilAcessoRepository;
import com.letscodeTCCSMH.TCCSMH.Repository.RequisicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilAcessoService {

    @Autowired
    private PerfilAcessoRepository perfilAcessoRepository;

    public void salvarPerfilAcesso(PerfilAcesso perfilAcesso) {
        if (perfilAcesso.getMaster()) {
            perfilAcesso.setMaster(false);
        }
        perfilAcessoRepository.save(perfilAcesso);
    }

    public PerfilAcesso buscarPerfilAcesso(String nome) {
        return perfilAcessoRepository.findByNome(nome);
    }
    public boolean atualizarPerfilAcesso(String nome, PerfilAcesso perfilAcesso) {
        PerfilAcesso perfilAcessoBD = perfilAcessoRepository.findByNome(nome);
        if (perfilAcesso != null) {
            perfilAcessoBD.setNome(perfilAcessoBD.getNome());
            perfilAcessoRepository.save(perfilAcessoBD);
            return true;
        }
        return false;
    }
    public boolean excluirPerfilAcesso(String nome) {
        PerfilAcesso perfilAcesso = perfilAcessoRepository.findByNome(nome);
        if (perfilAcesso != null) {
            perfilAcessoRepository.delete(perfilAcessoRepository.findByNome(nome));
            return true;
        }
        return false;
     }
     }
