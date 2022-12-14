package com.letscodeTCCSMH.TCCSMH.Controller;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Service.CadastroUsuarioService;
import com.letscodeTCCSMH.TCCSMH.dto.AlterarUsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class CadastroUsuarioController {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @PostMapping
    public ResponseEntity<String> salvarCadastroUsuario(@RequestBody @Valid CadastroUsuario cadastroUsuario) {
      cadastroUsuarioService.salvarCadastroUsuario(cadastroUsuario);
      return ResponseEntity.status(201).body("Cadastro realizado com Sucesso");
   }

     //localhost:8080/usuario/?loginEmail
    @GetMapping("/{loginEmail}")
    public CadastroUsuario buscaCadastroUsuario(@RequestParam("loginEmail") String loginEmail ){
        return cadastroUsuarioService.buscarCadastroPorEmail(loginEmail);
    }

    //localhost:8080/usuario/buscarPorNome?nomeCompleto=Jao
     @GetMapping("/buscarPorNome")
    public CadastroUsuario buscaCadastroPorNome(@RequestParam("nomeCompleto") String nomeCompleto){
        return cadastroUsuarioService.buscarCadastroPorNome(nomeCompleto);
    }


    //localhost:8080/usuario/juliana@bradesco.com.br (aqui sao os dados salvos ja no banco de dados)
    //no body vai a informacao que queremos trocar.
    @PutMapping("/{loginEmail}")
    public String atualizaCadastroUsuario(@PathVariable String loginEmail, @RequestBody AlterarUsuarioDto dto) {
        boolean atualizado = cadastroUsuarioService.atualizarCadastroUsuario(loginEmail, dto);
        if (atualizado) {
        return "Cadastro do usuário atualizado com sucesso";
    }
        return "Cadastro do usuário não encontrado";
    }

    //http://localhost:8080/usuario?nomeCompleto=Juliana
    @DeleteMapping
    public String deletaCadastroUsuario(@RequestParam("nomeCompleto") String nomeCompleto) {
        boolean deletado = cadastroUsuarioService.excluirCadastroUsuario(nomeCompleto);
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


