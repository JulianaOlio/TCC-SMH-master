package com.letscodeTCCSMH.TCCSMH.Model;

import java.util.ArrayList;
import java.util.List;

public class perfilAcesso {
    private String nome;

    private String descricao;

    private List<Permissao> permissao = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Permissao> getPermissao() {
        return permissao;
    }

    public void setPermissao(List<Permissao> permissao) {
        this.permissao = permissao;
    }
}