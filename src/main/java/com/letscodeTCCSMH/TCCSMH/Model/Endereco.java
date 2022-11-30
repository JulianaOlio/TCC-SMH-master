package com.letscodeTCCSMH.TCCSMH.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Tipo Lougradouro é obrigatório!")
    private String tipoLogradouro;

    @NotBlank(message = "Lougradouro é obrigatório!")
    private String logradouro;

    @NotBlank(message = "Número é obrigatório!")
    private String numero;

    @NotBlank(message = "Cep é obrigatório!")
    private String cep;

    @NotBlank(message = "Complemento é obrigatório!")
    private String complemento;

    @NotBlank(message = "Bairro é obrigatório!")
    private String bairro;

    @NotBlank(message = "Cidade é obrigatório!")
    private String cidade;

    @NotBlank(message = "Estado é obrigatório!")
    private String estado;

    /*@OneToOne
    @JoinColumn(name = "id_cadastro_usuario")
    @JsonIgnore
    private CadastroUsuario cadastroUsuario;*/


}
