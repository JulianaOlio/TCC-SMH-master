package com.letscodeTCCSMH.TCCSMH.Repository;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CadastroUsuarioRepository extends JpaRepository <CadastroUsuario,Long> {
    void save();
    CadastroUsuario findBycodigoFuncional(String codigoFuncional);
    void delete();
    CadastroUsuario findAll(String nomeCompleto);
    List<CadastroUsuarioRepository> findBynomeCompleto();
    CadastroUsuario findByid_Email(String id_Email);

    List<CadastroUsuarioRepository> findById_Email();

}

