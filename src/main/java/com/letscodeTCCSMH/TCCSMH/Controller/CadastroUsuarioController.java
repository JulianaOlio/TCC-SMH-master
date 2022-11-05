package com.letscodeTCCSMH.TCCSMH.Controller;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Repository.CadastroUsuarioRepository;
import com.letscodeTCCSMH.TCCSMH.Service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroUsuarioController {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @PostMapping
    public String salvarCadastroUsuario(@RequestBody CadastroUsuario cadastroUsuario) {
        if(cadastroUsuario.getLoginEmail() == null|| cadastroUsuario.getLoginEmail().equals("") ){
            return "E-mail do usuário é obrigatório";
        }
        if (cadastroUsuario.getNomeCompleto() == null || cadastroUsuario.getNomeCompleto().equals("")) {
            return "O nome do usuário é obrigatório";
        }

        if (cadastroUsuario.getCodigoFuncional() == null ||cadastroUsuario.getCodigoFuncional().equals("")) {
            return "O código funcionsl é obrigatório";
        }
        if (cadastroUsuario.getTelefone() == null ||cadastroUsuario.getTelefone().equals("")) {
            return "O telefone é obrigatório";
        }
        if (cadastroUsuario.getEndereco() == null) {
            return "O Endereço é obrigatório";

        }
        CadastroUsuario cadastroUsuarioBD =
                cadastroUsuarioService.buscarCadastroUsuario(cadastroUsuario.getLoginEmail());
        if (cadastroUsuarioBD != null) {
            return "E-mail já cadastrado.";
        }

        cadastroUsuarioService.salvarCadastroUsuario(cadastroUsuario);
        return "Cadastro realizado com sucesso!";
    }

    //localhost:8080/cadastro/abc@gmail.com
    @GetMapping("/{loginEmail}")
    public CadastroUsuario buscacadastroUsuario(@PathVariable String loginEmail){
        return cadastroUsuarioService.buscarCadastroUsuario(loginEmail);
    }

    @GetMapping("/nomeCompleto")
    public CadastroUsuario buscaCadastroPorNome(@RequestBody String nomeCompleto){
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


