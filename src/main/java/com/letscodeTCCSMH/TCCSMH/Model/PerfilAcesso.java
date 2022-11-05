package com.letscodeTCCSMH.TCCSMH.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "perfil_acesso")
public class PerfilAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPefilAcesso;
    private String nome;
    private String descricao;

    public Long getIdPefilAcesso() {
        return idPefilAcesso;
    }

    public void setIdPefilAcesso(Long idPefilAcesso) {
        this.idPefilAcesso = idPefilAcesso;
    }

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
    public CadastroUsuario getCadastroUsuario() {
        return cadastroUsuario;
    }

    public void setCadastroUsuario(CadastroUsuario cadastroUsuario) {
        this.cadastroUsuario = cadastroUsuario;
    }
}