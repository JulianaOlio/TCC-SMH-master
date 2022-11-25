package com.letscodeTCCSMH.TCCSMH.Service;


import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Model.PerfilAcesso;
import com.letscodeTCCSMH.TCCSMH.Model.Permissao;
import com.letscodeTCCSMH.TCCSMH.Model.Requisicao;
import com.letscodeTCCSMH.TCCSMH.Repository.CadastroUsuarioRepository;
import com.letscodeTCCSMH.TCCSMH.Repository.PerfilAcessoRepository;
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

       public Requisicao buscarRequisicao(Integer id) {
        var buscaRequisicao = requisicaoRepository.findById(id);
        if (buscaRequisicao.isEmpty()) {
            throw new IllegalArgumentException("permissao não encontrado!");
        }
        return buscaRequisicao.get();
    }

    public List<Requisicao> listarRequisicoes() {
        return requisicaoRepository.findAll();
    }

    public boolean atualizarRequisicao(Integer id, Requisicao requisicao) {
        Optional<Requisicao> requisicaoBD = requisicaoRepository.findById(id);
        if (!requisicaoBD.isEmpty()) {
            requisicao.setId(requisicao.getId());
            requisicao.setDataInicial(requisicao.getDataInicial());
            requisicao.setDataFinal(requisicao.getDataFinal());
            requisicao.setHorarioInicial(requisicao.getHorarioInicial());
            requisicao.setHorarioFinal(requisicao.getHorarioFinal());
            requisicao.setMotivo(requisicao.getMotivo());
            requisicao.setHeadSet(requisicao.getHeadSet());
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




