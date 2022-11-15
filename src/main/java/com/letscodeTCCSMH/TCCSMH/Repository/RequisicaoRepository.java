package com.letscodeTCCSMH.TCCSMH.Repository;


import com.letscodeTCCSMH.TCCSMH.Model.Requisicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoRepository extends JpaRepository<Requisicao,Integer>{


    boolean aprova(String requisicao);
}
