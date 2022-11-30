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
    //localhost:8080/endereco?atualizaCep=111 (esse 111 é o CEP que queremos alterar)
    @PutMapping
    public String atualizaEndereco(@RequestParam("atualizaCep") String cep, @RequestBody Endereco endereco) {
        boolean atualizar = enderecoService.atualizarEndereco(cep, endereco);
        if (atualizar) {
            return "Endereço atualizado com sucesso!";
        }
        return "Endereço não encontrado";
    }

    //http://localhost:8080/endereco?cep=111
    @DeleteMapping
    public String deletaEndereco(@RequestParam("cep") String cep) {
        boolean deletar = enderecoService.excluirEndereco(cep);
        if (deletar) {
      return "Endereço excluído com sucesso!";
    }
        return "Endereço não localizado";
}
}