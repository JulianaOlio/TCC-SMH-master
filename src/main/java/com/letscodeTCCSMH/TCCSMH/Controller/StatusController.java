package com.letscodeTCCSMH.TCCSMH.Controller;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Model.Status;
import com.letscodeTCCSMH.TCCSMH.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController{

    @Autowired
    private StatusService statusService;

    @PostMapping
    private String salvaStatus(@RequestBody Status status){
        statusService.salvarStatus(status);
        return "Status ataulizado com sucesso!";
    }
    @GetMapping("/buscarStatus")
    public Status buscaStatus(@RequestParam("status") String status){
        return statusService.buscarStatus(status);
    }
    @PutMapping("/atualizaStatus/?")
    public String atualizaStatus(@RequestParam("atualizarStatus") String atualizaStatus,@RequestBody Status Status) {
        boolean atualizar = statusService.atualizarStatus(atualizaStatus, Status);
        if (atualizar) {
            return "Status atualizado com sucesso";
        }
        return "Status não encontrado";
    }
    @DeleteMapping("/excluiStatus")
    public String deletaStatus(@RequestBody String status) {
        boolean statusDeletado = statusService.excluirStatus(status);
        if (statusDeletado) {
            return "Status excluído com sucesso!";
        }
        return "Status não encontrado.";
    }
    @GetMapping
    public List<Status> statusList(
            @RequestParam(name = "Status das Requisições", required = false) String status) {
        return statusService.listarStatus(status);
    }
}




