package com.letscodeTCCSMH.TCCSMH.Controller;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        if (cadastroUsuario.getTelefone() == null ||cadastroUsuario.getTelefone().equals("")) {
            return "O telefone é obrigatório";
        }

        if (cadastroUsuario.getEndereco() == null) {
            return "O Endereço é obrigatório";

        }
        CadastroUsuario cadastroUsuarioBD =
                cadastroUsuarioService.buscarCadastroUsuario(cadastroUsuario.getCodigoFuncional());
        if (cadastroUsuarioBD != null) {
            return "Código funcional já cadastrado.";
        }

        cadastroUsuarioService.salvarCadastroUsuario(cadastroUsuario);
        return "Cadastro realizado com sucesso!";
    }

    //localhost:8080/cadastro/1234567
    @GetMapping("/{codigoFuncional}")
    public CadastroUsuario getcadastroUsuario(@PathVariable String codigoFuncional){
        return cadastroUsuarioService.buscarCadastroUsuario(codigoFuncional);
    }

    @GetMapping("/{nomeCompleto}")
    public CadastroUsuario listarUsuarioPorNome(@PathVariable String nomeCompleto){
        return cadastroUsuarioService.listarCadastroUsuario(nomeCompleto);
    }

    @PutMapping("/{codigoFuncional}")
    public String atualizarCadastroUsuario(@PathVariable String codigoFuncional, @RequestBody CadastroUsuario cadastroUsuario) {
        boolean atualizado = cadastroUsuarioService.atualizarCadastroUsuario(codigoFuncional, cadastroUsuario);
        if (atualizado) {
        return "Cadastro do usuário atualizado com sucesso";
    }
        return "Cadastro do usuário não encontrado";
    }

    @DeleteMapping("/{codigoFuncional}")
    public String deletarCadastroUsuario(@PathVariable String codigoFuncional) {
        boolean deletado = cadastroUsuarioService.excluirCadastroUsuario(codigoFuncional);
        if (deletado) {
            return "Cadastro do usuário excluído com sucesso!";
        }
        return "Cadastro do usuário não encontrado.";
    }
    }
