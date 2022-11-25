package com.letscodeTCCSMH.TCCSMH.Controller;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Model.HeadSet;
import com.letscodeTCCSMH.TCCSMH.Service.CadastroUsuarioService;
import com.letscodeTCCSMH.TCCSMH.Service.HeadSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/headset")
public class HeadSetController {

    @Autowired
    private HeadSetService headSetService;

    @PostMapping
    public String salvaHeadSet(@RequestBody HeadSet headSet){
        headSetService.salvarHeadSet(headSet);
        return "HeadSet salvo com sucesso";
    }

    @GetMapping("/buscarHeadSet")
    public HeadSet buscaHeadSet(@RequestParam("id") Integer id){
        return headSetService.buscarHeadSet(id);
    }


    @PutMapping
    public ResponseEntity<Object> atualizaHeadSet(@RequestParam Integer id, HeadSet headSet) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Altualizando HeadSet" + headSetService
                        .atualizarHeadSet(id, headSet).getRequisicao().getCadastroUsuario() +
                        "alterado para " + headSet);

    }
        @DeleteMapping
    public ResponseEntity<HeadSet> deletaHeadSet(@PathVariable(value = "excluirHeadSet") Integer id) throws Exception {
        headSetService.excluiHeadSet(id);
        return ResponseEntity.noContent().build();
    }
}


