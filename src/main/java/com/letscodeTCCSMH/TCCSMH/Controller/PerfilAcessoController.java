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
        return"Perfil de acesso cadastrado com Sucesso";
}
    @GetMapping("/{nome}")
    public PerfilAcesso buscarPerfilPorNome(@PathVariable String nome){
        return  perfilAcessoService.buscarPerfilAcesso(nome);
    }
}
