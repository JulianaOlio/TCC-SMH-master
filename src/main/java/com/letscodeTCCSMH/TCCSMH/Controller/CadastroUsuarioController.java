package com.letscodeTCCSMH.TCCSMH.Controller;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Service.CadastroUsuarioService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class CadastroUsuarioController {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @PostMapping
    public String salvarCadastroUsuario(@RequestBody @NotNull CadastroUsuario cadastroUsuario) {
        CadastroUsuario cadastroUsuarioBD =
                cadastroUsuarioService.buscarCadastroUsuario(cadastroUsuario.getLoginEmail());
        if (cadastroUsuarioBD != null) {
            return "E-mail já cadastrado.";
        }

        cadastroUsuarioService.salvarCadastroUsuario(cadastroUsuario);
        return "Cadastro realizado com sucesso!";
    }

    //localhost:8080/usuario/?loginEmail
    //Esse getMappig com filtro "/" é possivel
    //filtra o usuario com um email especifico.
    //Usamos o RequestParam para ficar mais certo o filtro.
    @GetMapping("/")
    public CadastroUsuario buscaCadastroUsuario(@RequestParam("loginEmail") String loginEmail ){
        return cadastroUsuarioService.buscarCadastroUsuario(loginEmail);
    }

    //localhost:8080/usuario/buscarPorNome?nomeCompleto=Jao
    //Esse getMappig com filtro "/" é possivel
    //filtra o usuario com um nome completo especifico.
    //Usamos o RequestParam para ficar mais certo o filtro.

    //ver com o profe para colocar esses dois getMapping juntos com condicao ou para nao ficar muito repetitivo
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


