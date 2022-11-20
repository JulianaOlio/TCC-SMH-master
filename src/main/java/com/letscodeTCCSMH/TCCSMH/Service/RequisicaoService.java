package com.letscodeTCCSMH.TCCSMH.Service;


import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
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
    private CadastroUsuario cadastroUsuario;

    public void salvarRequisicao(Requisicao requisicao) {
        requisicaoRepository.save(requisicao);
    }
    public List<Requisicao> listarRequisicoes() {
        return requisicaoRepository.findAll();
    }

    public boolean atualizarRequisicao(Integer id, Requisicao requisicao) {
        Requisicao requisicaoBD = requisicaoRepository.findByRequisicao(id);
        if (requisicao!=null) {
            requisicaoBD.setId(requisicao.getId());
            requisicaoBD.setDataInicial(requisicao.getDataInicial());
            requisicaoBD.setDataFinal(requisicao.getDataFinal());
            requisicaoBD.setHorarioInicial(requisicao.getHorarioInicial());
            requisicaoBD.setHorarioFinal(requisicao.getHorarioFinal());
            requisicaoBD.setMotivo(requisicao.getMotivo());
            requisicaoBD.setHeadset(requisicao.getHeadset());
           requisicaoRepository.save(requisicao);
            return true;
        }
        return false;
    }

    public void excluirRequisicao(Integer id)  throws Exception {
        var requisicao = requisicaoRepository.findById(id);
        if (requisicao.isEmpty()){
            throw new Exception("Requisicao não localizada");
        }
        requisicaoRepository.deleteById(id);
    }
    }




