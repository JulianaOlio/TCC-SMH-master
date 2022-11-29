package com.letscodeTCCSMH.TCCSMH.dto;

//alterar no postman somnte o loginEmail, sem alterar todos os outros dados que estao com @notblank

import com.letscodeTCCSMH.TCCSMH.Model.Endereco;
import lombok.Data;

@Data
public class AlterarUsuarioDto {

    private String nomeCompleto;
    private String telefone;
    private Endereco endereco;


}
