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

    @NotBlank(message = "Número do HeadSet para manutenção é obrigatório!")
    private String numeroHeadSet;


    @OneToOne
    @JoinColumn
    private Requisicao requisicao;


 }
