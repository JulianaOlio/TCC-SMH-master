package com.letscodeTCCSMH.TCCSMH.Controller;


import com.letscodeTCCSMH.TCCSMH.Model.Requisicao;
import com.letscodeTCCSMH.TCCSMH.Service.RequisicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requisicao")
public class RequisicaoController{

    @Autowired
    public RequisicaoService requisicaoService;

    @PostMapping
    public String salvaRequisicao (@RequestBody Requisicao requisicao){
        requisicaoService.salvarRequisicao(requisicao);
        return "Requisicao salva com sucesso";
    }
}




