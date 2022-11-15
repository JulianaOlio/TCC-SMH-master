package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.PerfilAcesso;
import com.letscodeTCCSMH.TCCSMH.Model.Requisicao;
import com.letscodeTCCSMH.TCCSMH.Repository.RequisicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisicaoService {

    @Autowired
    private RequisicaoRepository requisicaoRepository;

    @Autowired
    private PerfilAcesso perfilAcesso;

    public void salvarRequisicao(Requisicao requisicao) {
        requisicaoRepository.save(requisicao);
    }

    private List<Requisicao> listaRequisicoes() {
        return requisicaoRepository.findAll();
    }

    private boolean aprovaRequisicao(String requisicao) {
        PerfilAcesso perfilAcesso = new PerfilAcesso();
        if (perfilAcesso.getMaster().equals(perfilAcesso.getMaster())) {
            return requisicaoRepository.aprova(requisicao);
        }
        return Boolean.parseBoolean("perfil não tem permissão ");
    }


    }

