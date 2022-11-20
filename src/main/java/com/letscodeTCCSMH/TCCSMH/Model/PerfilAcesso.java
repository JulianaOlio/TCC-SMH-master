package com.letscodeTCCSMH.TCCSMH.Model;

import com.letscodeTCCSMH.TCCSMH.Service.RequisicaoService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "perfil_acesso")
public class PerfilAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPerfilAcesso;
    private String nome;
    private String descricao;
    private Boolean master;


    @OneToOne
    private CadastroUsuario cadastroUsuario;

    @OneToMany
    private Set<Requisicao> requisicoes;

    public Integer getIdPerfilAcesso() {
        return idPerfilAcesso;
    }

    public void setIdPerfilAcesso(Integer idPerfilAcesso) {
        this.idPerfilAcesso = idPerfilAcesso;
    }

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

       public Boolean getMaster() {
        return master;
    }

    public void setMaster(Boolean master) {
        this.master = master;
    }

    public CadastroUsuario getCadastroUsuario() {
        return cadastroUsuario;
    }

    public void setCadastroUsuario(CadastroUsuario cadastroUsuario) {
        this.cadastroUsuario = cadastroUsuario;
    }
}
