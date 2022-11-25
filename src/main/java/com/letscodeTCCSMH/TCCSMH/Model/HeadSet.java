package com.letscodeTCCSMH.TCCSMH.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroAntigoHeadSet() {
        return numeroAntigoHeadSet;
    }

    public void setNumeroAntigoHeadSet(String numeroAntigoHeadSet) {
        this.numeroAntigoHeadSet = numeroAntigoHeadSet;
    }

    public String getNumeroNovoHeadSet() {
        return numeroNovoHeadSet;
    }

    public void setNumeroNovoHeadSet(String numeroNovoHeadSet) {
        this.numeroNovoHeadSet = numeroNovoHeadSet;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }
}
