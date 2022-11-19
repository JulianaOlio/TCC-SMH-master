package com.letscodeTCCSMH.TCCSMH.Model;


import javax.persistence.*;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String iniciado;
    private String emAndamento;
    private String cancelado;
    private String concluido;

    @ManyToOne
    private Requisicao requisicao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIniciado() {
        return iniciado;
    }
    public void setIniciado(String iniciado) {
        this.iniciado = iniciado;
    }
    public String getEmAndamento() {
        return emAndamento;
    }
    public void setEmAndamento(String emAndamento) {
        this.emAndamento = emAndamento;
    }
    public String getCancelado() {
        return cancelado;
    }
    public void setCancelado(String cancelado) {
        this.cancelado = cancelado;
    }
    public String getConcluido() {
        return concluido;
    }
    public void setConcluido(String concluido) {
        this.concluido = concluido;
    }
}
