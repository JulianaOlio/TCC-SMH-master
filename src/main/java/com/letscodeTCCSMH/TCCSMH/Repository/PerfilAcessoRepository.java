package com.letscodeTCCSMH.TCCSMH.Repository;

import com.letscodeTCCSMH.TCCSMH.Model.Endereco;
import com.letscodeTCCSMH.TCCSMH.Model.PerfilAcesso;
import org.springframework.data.repository.CrudRepository;

public interface PerfilAcessoRepository extends CrudRepository<PerfilAcesso, Integer> {

    PerfilAcesso findByNome (String nome);

}
