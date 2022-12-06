package com.letscodeTCCSMH.TCCSMH.Controller;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Model.HeadSet;
import com.letscodeTCCSMH.TCCSMH.Service.CadastroUsuarioService;
import com.letscodeTCCSMH.TCCSMH.Service.HeadSetService;
import com.letscodeTCCSMH.TCCSMH.dto.AlterarUsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/headset")
public class HeadSetController {

    @Autowired
    private HeadSetService headSetService;

    //localhost:8080/headset
    @PostMapping
    public String salvaHeadSet(@RequestBody HeadSet headSet) {
        headSetService.salvarHeadSet(headSet);
        return "HeadSet salvo com sucesso!";
    }

    //localhost:8080/headset
    @GetMapping
    public List<HeadSet> buscaListaHeadSet() {
        return headSetService.listaHeadSet();
    }

    //localhost:8080/headset?AtualizaHeadSet=111
    @PutMapping
    public String atualizarHeadSet(@RequestParam("atualiza") String numero, @RequestBody HeadSet headSet) {
        boolean atualizar = headSetService.atualizarHeadSet(numero, headSet);
        if (atualizar) {
            return "headSet atualizado com sucesso!";
        }
        return "headSet não encontrado!";
    }

    //localhost:8080/headset?Excluir=111
    @DeleteMapping
    public String excluindoHeadSet(@RequestParam("deletaHeadSet") String numeroHeadset) {
        boolean deletado = headSetService.excluirHeadSet(numeroHeadset);
        if (deletado) {
            return "HeadSet do usuário excluído com sucesso!";
        }
        return "HeadSet  do usuário não encontrado.";
    }
}


