package com.letscodeTCCSMH.TCCSMH.Model;

import javax.persistence.*;

@Entity
public class Permissao {
    @Id
    private String codigoPermissao;
    private String nomePermissao;


    public String getCodigoPermissao() {
        return codigoPermissao;
    }
    public void setCodigoPermissao(String codigoPermissao) {
        this.codigoPermissao = codigoPermissao;
    }
    public String getNomePermissao() {
        return nomePermissao;
    }
    public void setNomePermissao(String nomePermissao) {
        this.nomePermissao = nomePermissao;
    }


}
