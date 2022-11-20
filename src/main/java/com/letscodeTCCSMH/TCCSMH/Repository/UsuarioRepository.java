package com.letscodeTCCSMH.TCCSMH.Repository;

import com.letscodeTCCSMH.TCCSMH.Model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);


    }

