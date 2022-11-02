package com.letscodeTCCSMH.TCCSMH.Model;

import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

public class PerfilAcesso {

    private String nome;
    private String descricao;

    @OneToOne
    private CadastroUsuario cadastroUsuario;

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