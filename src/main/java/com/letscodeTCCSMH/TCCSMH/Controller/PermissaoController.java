package com.letscodeTCCSMH.TCCSMH.Controller;


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

    @DeleteMapping("/{excluiPermissao}")
    public ResponseEntity<Object> excluiPermissao(@PathVariable (value = "excluiPermissao")Integer codigoPermissao) throws Exception {
        permissaoService.excluirPermissao(codigoPermissao);
        return ResponseEntity.noContent().build();
    }
    }

