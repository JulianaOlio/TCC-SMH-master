package com.letscodeTCCSMH.TCCSMH.Controller;


import com.letscodeTCCSMH.TCCSMH.Model.Endereco;
import com.letscodeTCCSMH.TCCSMH.Model.Requisicao;
import com.letscodeTCCSMH.TCCSMH.Service.RequisicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requisicao")
public class RequisicaoController {

    @Autowired
    public RequisicaoService requisicaoService;

    @PostMapping
    public String salvaRequisicao(@RequestBody Requisicao requisicao) {
        requisicaoService.salvarRequisicao(requisicao);
        return "Requisicao salva com sucesso";
    }
    @GetMapping
    public List<Requisicao> listaRequisicao() {
        return requisicaoService.listarRequisicoes();
    }

    @DeleteMapping("/{excluirRequisicao}")
    public String deletaRequisica(@PathVariable("excluirRequisicao") Integer id) {
        boolean excluirRequisicao = requisicaoService.excluirRequisicao(id);
        if (excluirRequisicao) {
            return "Requisicao excluida com sucesso";
        }
        return "Requisicao não encontrada";
    }
}




