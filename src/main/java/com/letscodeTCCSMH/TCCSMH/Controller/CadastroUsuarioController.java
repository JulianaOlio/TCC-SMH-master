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
                cadastroUsuarioService.buscarCadastroUsuario(cadastroUsuario.getid_Email());
        if (cadastroUsuarioBD != null) {
            return "E-mail já cadastrado.";
        }

        cadastroUsuarioService.salvarCadastroUsuario(cadastroUsuario);
        return "Cadastro realizado com sucesso!";
    }

    //localhost:8080/cadastro/abc@gmail.com
    @GetMapping("/{id_Email}")
    public CadastroUsuario buscacadastroUsuario(@PathVariable String id_Email){
        return cadastroUsuarioService.buscarCadastroUsuario(id_Email);
    }

    @GetMapping("/nomeCompleto")
    public CadastroUsuario buscaCadastroPorNome(@RequestBody String nomeCompleto){
        return cadastroUsuarioService.buscarCadastroPorNome(nomeCompleto);
    }

    @PutMapping("/{id_Email}")
    public String atualizaCadastroUsuario(@PathVariable String id_Email, @RequestBody CadastroUsuario cadastroUsuario) {
        boolean atualizado = cadastroUsuarioService.atualizarCadastroUsuario(id_Email, cadastroUsuario);
        if (atualizado) {
        return "Cadastro do usuário atualizado com sucesso";
    }
        return "Cadastro do usuário não encontrado";
    }

    @DeleteMapping("/{id_Email}")
    public String deletaCadastroUsuario(@PathVariable String id_Email) {
        boolean deletado = cadastroUsuarioService.excluirCadastroUsuario(id_Email);
        if (deletado) {
            return "Cadastro do usuário excluído com sucesso!";
        }
        return "Cadastro do usuário não encontrado.";
    }

    @GetMapping
    public List<CadastroUsuarioRepository> listarCadastroUsuarios(
            @RequestParam(name = "Nomes dos Usuários", required = false) String nomeCompleto) {
            return cadastroUsuarioService.listarCadastroUsuarios(nomeCompleto);
    }
    }
