package com.letscodeTCCSMH.TCCSMH.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeadSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Número do Antigo HeadSet para manutenção é obrigatório")
    private String numeroAntigoHeadSet;

    @NotBlank(message = "Número do Nono HeadSet para substituição é obrigatório")
    private String numeroNovoHeadSet;

    @OneToOne
    @JoinColumn
    private Requisicao requisicao;

    @OneToOne
    @JoinColumn
    private CadastroUsuario cadastroUsuario;
 }
