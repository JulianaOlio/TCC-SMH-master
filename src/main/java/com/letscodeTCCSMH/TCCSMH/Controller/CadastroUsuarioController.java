package com.letscodeTCCSMH.TCCSMH.Controller;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class CadastroUsuarioController {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @PostMapping
    public String salvarCadastroUsuario(@RequestBody @Valid CadastroUsuario cadastroUsuario) {
         cadastroUsuarioService.salvarCadastroUsuario(cadastroUsuario);
         return "Cadastro realizado com sucesso!";
    }

    //localhost:8080/usuario/?loginEmail
    @GetMapping("/")
    public CadastroUsuario buscaCadastroUsuario(@RequestParam("loginEmail") String loginEmail ){
        return cadastroUsuarioService.buscarCadastroUsuario(loginEmail);
    }

    //localhost:8080/usuario/buscarPorNome?nomeCompleto=Jao
     @GetMapping("/buscarPorNome")
    public CadastroUsuario buscaCadastroPorNome(@RequestParam("nomeCompleto") String nomeCompleto){
        return cadastroUsuarioService.buscarCadastroPorNome(nomeCompleto);
    }

    @PutMapping("/{loginEmail}")
    public String atualizaCadastroUsuario(@PathVariable String loginEmail, @RequestBody CadastroUsuario cadastroUsuario) {
        boolean atualizado = cadastroUsuarioService.atualizarCadastroUsuario(loginEmail, cadastroUsuario);
        if (atualizado) {
        return "Cadastro do usuário atualizado com sucesso";
    }
        return "Cadastro do usuário não encontrado";
    }

    @DeleteMapping("/{loginEmail}")
    public String deletaCadastroUsuario(@PathVariable String loginEmail) {
        boolean deletado = cadastroUsuarioService.excluirCadastroUsuario(loginEmail);
        if (deletado) {
            return "Cadastro do usuário excluído com sucesso!";
        }
        return "Cadastro do usuário não encontrado.";
    }

        @GetMapping
        public List<CadastroUsuario> cadastroUsuarios(
                @RequestParam(name = "Nomes dos Usuários", required = false) String nomeCompleto) {
        return cadastroUsuarioService.listarCadastroUsuarios(nomeCompleto);
        }

}


