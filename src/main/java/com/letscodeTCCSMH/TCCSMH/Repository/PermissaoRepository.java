package com.letscodeTCCSMH.TCCSMH.Repository;

import com.letscodeTCCSMH.TCCSMH.Model.PerfilAcesso;
import com.letscodeTCCSMH.TCCSMH.Model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Integer>{


    Permissao findByNomePermissao(String nomePermissao);
}
