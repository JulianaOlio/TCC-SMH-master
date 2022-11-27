package com.letscodeTCCSMH.TCCSMH.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;
import javax.validation.constraints.Email;


@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name="CadastroUsuario")
public class CadastroUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Email",unique = true)
    @Email
    @NotBlank(message = "O E-mail é obrigatório")
    private String loginEmail;

    @Column(name = "nomeCompleto", unique = true)
    @NotBlank(message ="O Nome Completo é obrigatório")
    private String nomeCompleto;

    @Column(name = "codigoFuncional", unique = true)
    @NotBlank(message ="O Codigo Funcional é obrigatório")
    private String codigoFuncional;

    @Column(name = "telefonePrincipal")
    @NotBlank(message ="O Telefone é obrigatório")
    private String telefone;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

    @OneToOne
    @JoinColumn(name = "idPerfilAcesso")
    @JsonIgnore
    private PerfilAcesso perfilAcesso;


    @OneToMany(mappedBy = "cadastroUsuario")
    @JsonIgnore
    private Set<Requisicao> requisicoes;

    @OneToOne
    @JoinColumn
    private HeadSet headSet;

    public CadastroUsuario(CadastroUsuario usuario) {
    }
}