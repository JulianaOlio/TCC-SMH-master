package com.letscodeTCCSMH.TCCSMH.Repository;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CadastroUsuarioRepository extends CrudRepository<CadastroUsuario,Long> {

    CadastroUsuario findBycodigoFuncional(String codigoFuncional);
    List<CadastroUsuario> findAll();
    CadastroUsuario findByLoginEmail(String loginEmail);
    CadastroUsuario findByNomeCompleto(String nomeCompleto);
}

