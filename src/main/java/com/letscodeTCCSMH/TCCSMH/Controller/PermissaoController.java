package com.letscodeTCCSMH.TCCSMH.Controller;


import com.letscodeTCCSMH.TCCSMH.Model.PerfilAcesso;
import com.letscodeTCCSMH.TCCSMH.Model.Permissao;
import com.letscodeTCCSMH.TCCSMH.Service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class PermissaoController {


    @Autowired
    public PermissaoService permissaoService;

    @PostMapping
    public String salvaPermissao(@RequestBody Permissao permissao) {
        permissaoService.salvarPermissao(permissao);
        return "Permissao cadastrada com sucesso!";
    }

    @GetMapping("/{codigoPermissao}")
    public ResponseEntity<Object> buscarPermissoaCodigoPermissao(@PathVariable(value ="codigoPermissao")Integer codigoPermissao){
        permissaoService.buscarPermissao(codigoPermissao);
        return ResponseEntity.ok().build();
         }

    @PutMapping("/{nome}")
    public String atualizaPermissao(@RequestParam("atualizaPermissão") String nomePermissao, @RequestBody Permissao permissao) {
        boolean atualizado = permissaoService.atualizarPermissao(nomePermissao, permissao);
        if (atualizado) {
            return "Permissão atualizada com sucesso.";
        }
        return "Permissão não encontrada.";
    }
    @DeleteMapping("/{excluiPermissao}")
    public ResponseEntity<Object> excluiPermissao(@PathVariable (value = "excluiPermissao")Integer codigoPermissao) throws Exception {
        permissaoService.excluirPermissao(codigoPermissao);
        return ResponseEntity.noContent().build();
    }
    }

