package com.letscodeTCCSMH.TCCSMH.Repository;

import com.letscodeTCCSMH.TCCSMH.Model.LoginAcesso;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public interface LoginAcessoRepository extends JpaRepository<LoginAcesso, Long> {

      Optional<LoginAcesso> findByUsername(String login);


    }
