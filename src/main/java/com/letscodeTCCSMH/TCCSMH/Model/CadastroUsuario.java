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
public class CadastroUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Email
    @NotBlank(message = "E-mail é obrigatório")
    private String loginEmail;
    @NotBlank(message ="Nome completo é obrigatório")
    private String nomeCompleto;

    @Column(unique = true)
    @NotBlank(message ="Codigo Funcional é obrigatório")
    private String codigoFuncional;

    @NotBlank(message ="Telefone é obrigatório")
    private String telefone;
    @OneToOne(cascade = CascadeType.ALL)
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

}