package com.letscodeTCCSMH.TCCSMH.Model;

import java.time.LocalDateTime;

public class Requisicao {

    private Integer id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFinal;
    private String motivo;
    private String headset;

    private Usuario requisicaoPorUsuario;
    private Status statusRequisicao;
    private Master aprovadorRequisicao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getHeadset() {
        return headset;
    }

    public void setHeadset(String headset) {
        this.headset = headset;
    }

    public Usuario getRequisicaoPorUsuario() {
        return requisicaoPorUsuario;
    }

    public void setRequisicaoPorUsuario(Usuario requisicaoPorUsuario) {
        this.requisicaoPorUsuario = requisicaoPorUsuario;
    }

    public Status getStatusRequisicao() {
        return statusRequisicao;
    }

    public void setStatusRequisicao(Status statusRequisicao) {
        this.statusRequisicao = statusRequisicao;
    }

    public Master getAprovadorRequisicao() {
        return aprovadorRequisicao;
    }

    public void setAprovadorRequisicao(Master aprovadorRequisicao) {
        this.aprovadorRequisicao = aprovadorRequisicao;
    }
}
