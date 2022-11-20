package com.letscodeTCCSMH.TCCSMH.Model;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "loginUsuario")
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Email
        @Column(name = "email", nullable = false, unique = true)
        private String email;

        @Column(name = "senha", nullable = false)
        private String senha;


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

        public Long getId() {
            return id;
        }


        public void setId(Long id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }
    }

