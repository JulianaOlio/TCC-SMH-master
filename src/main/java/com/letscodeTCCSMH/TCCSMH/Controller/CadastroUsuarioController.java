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
        if (cadastroUsuario.getLoginEmail() == null || cadastroUsuario.getLoginEmail().equals("")) {
            return "E-mail do usuário é obrigatório";
        }
        if (cadastroUsuario.getNomeCompleto() == null || cadastroUsuario.getNomeCompleto().equals("")) {
            return "O nome do usuário é obrigatório";
        }

        if (cadastroUsuario.getCodigoFuncional() == null || cadastroUsuario.getCodigoFuncional().equals("")) {
            return "O código funcionsl é obrigatório";
        }
        if (cadastroUsuario.getTelefone() == null || cadastroUsuario.getTelefone().equals("")) {
            return "O telefone é obrigatório";
        }

        if (cadastroUsuario.getEndereco().getTipoLogradouro() == null || cadastroUsuario.getEndereco().getTipoLogradouro().equals("")) {
            return "O tipo logradouro é obrigatório";
        }

        if (cadastroUsuario.getEndereco().getLogradouro() == null || cadastroUsuario.getEndereco().getLogradouro().equals("")) {
            return "O logradouro é obrigatório";
        }

        if (cadastroUsuario.getEndereco().getNumero() == null || cadastroUsuario.getEndereco().getNumero().equals("")) {
            return "O número é obrigatório";
        }

        if (cadastroUsuario.getEndereco().getCep() == null || cadastroUsuario.getEndereco().getCep().equals("")) {
            return "O CEP é obrigatório";
        }

        if (cadastroUsuario.getEndereco().getComplemento() == null || cadastroUsuario.getEndereco().getComplemento().equals("")) {
            return "O complemento é obrigatório";
        }

        if (cadastroUsuario.getEndereco().getBairro() == null || cadastroUsuario.getEndereco().getBairro().equals("")) {
            return "O bairro é obrigatório";
        }

        if (cadastroUsuario.getEndereco().getCidade() == null || cadastroUsuario.getEndereco().getCidade().equals("")) {
            return "A cidade é obrigatória";
        }
        if (cadastroUsuario.getEndereco().getEstado() == null || cadastroUsuario.getEndereco().getEstado().equals("")) {
            return "O estado é obrigatório";
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
    public CadastroUsuario buscaCadastroUsuario(@PathVariable String loginEmail){
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


