package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.PerfilAcesso;
import com.letscodeTCCSMH.TCCSMH.Repository.CadastroUsuarioRepository;
import com.letscodeTCCSMH.TCCSMH.Repository.PerfilAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilAcessoService {

    @Autowired
    private PerfilAcessoRepository perfilAcessoRepository;

    public void salvarPerfilAcesso(PerfilAcesso perfilAcesso){
        perfilAcessoRepository.save(perfilAcesso);
    }

    public PerfilAcesso buscarPerfilAcesso(String nome){
        perfilAcessoRepository.findByNome(nome);

}
