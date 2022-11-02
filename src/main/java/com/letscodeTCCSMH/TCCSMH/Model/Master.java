package com.letscodeTCCSMH.TCCSMH.Model;

import javax.persistence.*;

@Entity
public class Master extends CadastroUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    @JoinColumn(name = "perfil_acesso_nome")
    private PerfilAcesso perfilAcesso;

    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }
}
