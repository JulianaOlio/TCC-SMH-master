package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Controller.PermissaoController;
import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Model.Permissao;
import com.letscodeTCCSMH.TCCSMH.Model.Requisicao;
import com.letscodeTCCSMH.TCCSMH.Repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;



    public void salvarPermissao(Permissao permissao) {
        permissaoRepository.save(permissao);
    }

    public List<Permissao> listarPemissoes() {
        return permissaoRepository.findAll();
    }

    public Permissao buscarPermissao(Integer codigoPermissao) {
        var buscaPermissao = permissaoRepository.findById(codigoPermissao);
        if (!buscaPermissao.isPresent()) {
            throw new IllegalArgumentException("permissao não encontrado!");
        }
        return buscaPermissao.get();
    }

    public boolean atualizarPermissao (String nomePermissao, Permissao permissao) {
        Permissao permissaoDB = permissaoRepository.findByNomePermissao(nomePermissao);
        if (permissao != null) {
            permissaoDB.setCodigoPermissao(permissao.getCodigoPermissao());
            permissaoDB.setNomePermissao(permissao.getNomePermissao());
            permissaoRepository.save(permissao);
            return true;
        }
        return false;
    }


    public void excluirPermissao(Integer codigoPermissao)  throws Exception {
        var permissao = permissaoRepository.findById(codigoPermissao);
        if (permissao.isEmpty()){
            throw new Exception("permissao não localizada");
        }
        permissaoRepository.deleteById(codigoPermissao);
    }
}
