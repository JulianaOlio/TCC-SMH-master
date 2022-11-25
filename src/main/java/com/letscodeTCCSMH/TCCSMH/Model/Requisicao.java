package com.letscodeTCCSMH.TCCSMH.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jshell.Snippet;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Requisicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataInicial;

    @JsonFormat(pattern = "HH:MM")
    private LocalTime horarioInicial;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataFinal;

    @JsonFormat(pattern = "HH:MM")
    private LocalTime horarioFinal;
    private String motivo;


    @Enumerated(EnumType.STRING)
    @Column(name = "Status_requisicao_id")
    private StatusEnum status;

    @ManyToOne
    @JoinColumn
    private PerfilAcesso perfilAcesso;

    @ManyToOne
    @JoinColumn(name = "dados_solicitante")
    private CadastroUsuario cadastroUsuario;

    @OneToOne
    @JoinColumn(name = "headset")
    private HeadSet headSet;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalTime getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(LocalTime horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public LocalTime getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(LocalTime horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
    public HeadSet getHeadSet() {
        return headSet;
    }

    public void setHeadSet(HeadSet headSet) {
        this.headSet = headSet;
    }

   }
