package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.Requisicao;
import com.letscodeTCCSMH.TCCSMH.Repository.RequisicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RequisicaoService {
    @Autowired
    private RequisicaoRepository requisicaoRepository;

    public void salvarRequisicao(Requisicao requisicao) {
        requisicaoRepository.save(requisicao);
    }
    public List<Requisicao> listarRequisicoes() {
        return requisicaoRepository.findAll();
    }
    public void excluirRequisicao(Integer id)  throws Exception {
        var requisicao = requisicaoRepository.findById(id);
        if (requisicao.isEmpty()){
            throw new Exception("Usuário não localizado");
        }
        requisicaoRepository.deleteById(id);
    }
    }




