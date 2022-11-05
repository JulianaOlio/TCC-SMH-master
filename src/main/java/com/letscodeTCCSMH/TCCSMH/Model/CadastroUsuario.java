package com.letscodeTCCSMH.TCCSMH.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letscodeTCCSMH.TCCSMH.Repository.CadastroUsuarioRepository;

import javax.persistence.*;
import java.util.List;


@Entity
public class CadastroUsuario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Email;

    @Column(unique=true)
    private String loginEmail;
    private String nomeCompleto;
    private String codigoFuncional;
    private String telefone; //verificar se precisa uma classe apartada do telefone. se criar a lista precisaremos criar classe telefone

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

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
