package com.letscodeTCCSMH.TCCSMH.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letscodeTCCSMH.TCCSMH.Service.RequisicaoService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "perfil_acesso")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PerfilAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPerfilAcesso;
    private String nome;
    private String descricao;
    private Boolean master;


    /*@OneToOne
    private CadastroUsuario cadastroUsuario;*/


    @OneToMany(mappedBy = "cadastroUsuario")
    @JsonIgnore
    private Set<Requisicao> perfilAcessos;


}
