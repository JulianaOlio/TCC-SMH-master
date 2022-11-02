package com.letscodeTCCSMH.TCCSMH.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class CadastroUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_Email;

    private String nomeCompleto;
    private String codigoFuncional;
    private String telefone; //verificar se precisa uma classe apartada do telefone.

    @OneToOne
    private Endereco endereco;

    @OneToOne
    @JoinColumn (name = "id_perfilacesso")
    @JsonIgnore
    private PerfilAcesso perfilAcesso;

    public String getid_Email() {
        return id_Email;
    }

    public void setId_Email(String email) {
        this.id_Email = email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nome) {
        this.nomeCompleto = nome;
    }

    public String getCodigoFuncional() {
        return codigoFuncional;
    }

    public void setCodigoFuncional(String codigoFuncional) {
        this.codigoFuncional = codigoFuncional;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
