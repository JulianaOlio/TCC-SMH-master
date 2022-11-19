package com.letscodeTCCSMH.TCCSMH.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letscodeTCCSMH.TCCSMH.Repository.CadastroUsuarioRepository;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import javax.validation.constraints.Email;


@Entity
public class CadastroUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    //inserir anotacao @NotBlank
    //ibernate validation

    @Email
    @NotBlank(message = "E-mail é obrigatório")
    private String loginEmail;

    @NotBlank(message ="Nome completo é obrigatório")
    private String nomeCompleto;

    @NotBlank(message ="Codigo Funcional é obrigatório")
    private String codigoFuncional;

    @NotBlank(message ="Telefone é obrigatório")
    private String telefone; //verificar se precisa uma classe apartada do telefone. se criar a lista precisaremos criar classe telefone

    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;


    @OneToOne
    @JoinColumn(name = "id_perfil_acesso")
    @JsonIgnore
    private PerfilAcesso perfilAcesso;


    @OneToMany(mappedBy = "cadastroUsuario")
    @JsonIgnore
    private List<Requisicao> requisicoes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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

    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}