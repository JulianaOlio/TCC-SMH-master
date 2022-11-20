package com.letscodeTCCSMH.TCCSMH.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoPermissao;
    private String nomePermissao;

    @OneToMany
    private List<Requisicao> requisicoes;

    public Integer getCodigoPermissao() {
        return codigoPermissao;
    }

    public void setCodigoPermissao(Integer codigoPermissao) {
        this.codigoPermissao = codigoPermissao;
    }

    public String getNomePermissao() {
        return nomePermissao;
    }

    public void setNomePermissao(String nomePermissao) {
        this.nomePermissao = nomePermissao;
    }
}