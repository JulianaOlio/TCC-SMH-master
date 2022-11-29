package com.letscodeTCCSMH.TCCSMH.Controller;

import com.letscodeTCCSMH.TCCSMH.Model.Endereco;
import com.letscodeTCCSMH.TCCSMH.Service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public Endereco salvandoEndereco(@RequestBody @Valid Endereco endereco) {
        return enderecoService.salvaEndereco(endereco);
    }

    //Verificar para retornar o endereco quando faz a chamada.
    @GetMapping
    public List<Endereco> buscaListaEndereco() {
        return enderecoService.listaEndereco();
    }
    @PutMapping("/atualizaCep")
    public String atualizaEndereco(@RequestParam(name = "atualizaCep") String cep, @RequestBody Endereco endereco) {
        boolean atualizar = enderecoService.atualizarEndereco(cep, endereco);
        if (atualizar) {
            return "Endereço atualizado com sucesso";
        }
        return "Endereço não encontrado";
    }

    @DeleteMapping("/{excluirEndereco}")
    public String deletaEndereco(@PathVariable("excluirEndereco") String cep) {
        boolean deletar = enderecoService.excluirEndereco(cep);
        if (deletar) {
      return "Endereço excluido com sucesso";
    }
        return "Endereço não localizado";
}
}