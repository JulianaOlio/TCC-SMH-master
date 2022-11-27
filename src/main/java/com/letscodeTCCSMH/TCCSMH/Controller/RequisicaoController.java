package com.letscodeTCCSMH.TCCSMH.Controller;


import com.letscodeTCCSMH.TCCSMH.Model.Requisicao;
import com.letscodeTCCSMH.TCCSMH.Service.CSVService;
import com.letscodeTCCSMH.TCCSMH.Service.RequisicaoService;
import org.hibernate.loader.plan.build.internal.CascadeStyleLoadPlanBuildingAssociationVisitationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/requisicao")
public class RequisicaoController {

    @Autowired
    public RequisicaoService requisicaoService;

    @Autowired
    public CSVService csvService;

    @PostMapping
    public String salvaRequisicao(@RequestBody Requisicao requisicao) {
        requisicaoService.salvarRequisicao(requisicao);
        return "Requisicao salva com sucesso";
    }

    @GetMapping
    public List<Requisicao> listaRequisicao() {
        return requisicaoService.listarRequisicoes();
    }

    @PutMapping("/{atualizaRequisicao}")
    public String atualizaRequisicao(@PathVariable Integer id, @RequestBody Requisicao requisicao) {
        boolean atualizando = requisicaoService.atualizarRequisicao(id, requisicao);
        if (atualizando) {
            return "Requisicao do usuário atualizado com sucesso";
        }
        return "Requisicao do usuário não encontrado";
    }

    @DeleteMapping
    public ResponseEntity<Requisicao> deletaRequisicao(@PathVariable(value = "excluirRequisicao") Integer id) throws Exception {
        requisicaoService.excluirRequisicao(id);
        return ResponseEntity.noContent().build();
    }

  @GetMapping("/relatorioRequisicao")
   public void buscarRelatorioCSV(HttpServletResponse servletResponse) throws Exception{
        servletResponse.setContentType("texto/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"relatorioGeral.csv\"");
        csvService.writeRelatorioRequisicaoParaCSV(servletResponse.getWriter());
  }

}



