package com.letscodeTCCSMH.TCCSMH.Controller;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Model.Status;
import com.letscodeTCCSMH.TCCSMH.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @DeleteMapping("/{excluiStatus}")
    public ResponseEntity<Object> deletaStatus(@PathVariable (value = "excluiStatus")Integer id) throws Exception {
        statusService.deletarStatus(id);
            return ResponseEntity.noContent().build();
    }
   }




