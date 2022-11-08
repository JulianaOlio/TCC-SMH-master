package com.letscodeTCCSMH.TCCSMH.Controller;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Model.Endereco;
import com.letscodeTCCSMH.TCCSMH.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public String CadastroEndereco(@RequestBody Endereco endereco) {

        if (endereco.getTipoLogradouro() == null || endereco.getTipoLogradouro().equals("")) {
            return "Tipo de Logradouro é obrigatório para o pedido";
        }
        if (endereco.getLogradouro() == null || endereco.getLogradouro().equals("")){
            return "Logradouro é obrigatório para o pedido";
        }
        if (endereco.getNumero() == null || endereco.getNumero().equals("")){
            return "O número é obrigatório para o pedido";
        }
        if (endereco.getComplemento() == null || endereco.getComplemento().equals("")){
            return "Completo é obrigatório";
        }
        if (endereco.getBairro() == null || endereco.getBairro().equals("")){
            return  "Bairro é obrigatório para o pedido";
        }
        if (endereco.getCidade() == null || endereco.getCidade().equals("")){
            return "A cidade é obrigatória para o pedido";
        }
        if (endereco.getCep() == null || endereco.getCep().equals("")){
            return "O CEP é obrigatório para o pedido";
        }
        if (endereco.getEstado() == null || endereco.getEstado().equals("")){
            return "O Estado é obrigatório para o pedido";
        }
        Endereco enderecoBD = enderecoService.salvarEndereco(endereco);


        return null;
    }
}