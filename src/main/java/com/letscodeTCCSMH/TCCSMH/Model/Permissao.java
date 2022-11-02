package com.letscodeTCCSMH.TCCSMH.Model;

import javax.persistence.*;

@Entity
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigoPermissao;
    private String nomePermissao;



    @OneToOne
    private Master master;
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

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
}
