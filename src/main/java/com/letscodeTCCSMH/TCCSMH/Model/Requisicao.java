package com.letscodeTCCSMH.TCCSMH.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Requisicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFinal;
    private String motivo;
    private String headset;

    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status; // verificar se criamos a lista

    @OneToOne
    @JoinColumn(name = "status_requisicao_id")
    private Status statusRequisicao;

    @OneToOne
    @JoinColumn
    private PerfilAcesso perfilAcesso;
    @ManyToOne
    @JoinColumn(name = "dados_solicitante")
    private CadastroUsuario cadastroUsuario;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatusRequisicao() {
        return statusRequisicao;
    }

    public void setStatusRequisicao(Status statusRequisicao) {
        this.statusRequisicao = statusRequisicao;
    }

    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }

    public CadastroUsuario getCadastroUsuario() {
        return cadastroUsuario;
    }

    public void setCadastroUsuario(CadastroUsuario cadastroUsuario) {
        this.cadastroUsuario = cadastroUsuario;
    }
}