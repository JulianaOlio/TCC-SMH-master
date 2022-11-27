package com.letscodeTCCSMH.TCCSMH.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
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

   }
