package com.letscodeTCCSMH.TCCSMH.Controller;


import com.letscodeTCCSMH.TCCSMH.Model.PerfilAcesso;
import com.letscodeTCCSMH.TCCSMH.Repository.PerfilAcessoRepository;
import com.letscodeTCCSMH.TCCSMH.Service.PerfilAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfil_acesso")
public class PerfilAcessoController {

    @Autowired
    private PerfilAcessoService perfilAcessoService;

    @PostMapping
    public String salvarPerfildeAcesso(@RequestBody PerfilAcesso perfilAcesso) {
        perfilAcessoService.salvarPerfilAcesso(perfilAcesso);
        return "Perfil de acesso cadastrado com Sucesso";
    }

    @GetMapping("/{nome}")
    public PerfilAcesso buscarPerfilPorNome(@PathVariable String nome) {
        return perfilAcessoService.buscarPerfilAcesso(nome);
    }
      @PutMapping("/{nome}")
    public String atualizaPerfilAcesso(@PathVariable String nome, @RequestBody PerfilAcesso perfilAcesso) {
        boolean atualizado = perfilAcessoService.atualizarPerfilAcesso(nome, perfilAcesso);
        if (atualizado) {
            return "Perfil de acesso atualizado com sucesso";
        }
        return "Perfil de Acesso não encontrado.";
    }

      @DeleteMapping("/{nome}")
       public String deletaPerfilAcesso(@PathVariable String nome) {
        boolean deletado = perfilAcessoService.excluirPerfilAcesso(nome);
        if (deletado) {
           return "Perfil de Acesso excluído com sucesso!";
        }
        return "Perfil de Acesso não encontrado.";

    }
}

