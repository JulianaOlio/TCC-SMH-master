package com.letscodeTCCSMH.TCCSMH.Repository;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CadastroUsuarioRepository extends JpaRepository <CadastroUsuarioRepository,String> {
    void save();

    CadastroUsuario findBycodigoFuncional(String codigoFuncional);
    void delete();

    CadastroUsuario findAll(String nomeCompleto);

    List<CadastroUsuarioRepository> findBycodigoFuncional();
}

