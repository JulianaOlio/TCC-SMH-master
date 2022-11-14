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
    public Endereco salvaEndereco(@RequestBody Endereco endereco) {
        return enderecoService.salvarEndereco(endereco);
    }
//teste git
    @GetMapping("/buscaEndereco")
    public Endereco buscaEndereco(@RequestBody Endereco endereco) {
        return enderecoService.buscarEndereco(endereco);
    }

    @PutMapping("/{atualizaCep}")
    public String atualizaEndereco(@PathVariable String cep, @RequestBody Endereco endereco) {
        boolean atualizar = enderecoService.atualizarEndereco(cep, endereco);
        if (atualizar) {
            return "Endereço atualizado com sucesso";
        }
        return "Endereço não encontrado";
    }

    @DeleteMapping("{/excluirEndereco}")
    public String deletaEndereco(@PathVariable String cep) {
        boolean deletar = enderecoService.excluirEndereco(cep);
        if (deletar) {
      return "Endereço excluido com sucesso";
    }
        return "Endereço não localizado";
}
}