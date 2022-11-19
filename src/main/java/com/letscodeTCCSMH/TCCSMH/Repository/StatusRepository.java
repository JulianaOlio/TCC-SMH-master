package com.letscodeTCCSMH.TCCSMH.Repository;

import com.letscodeTCCSMH.TCCSMH.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status,Integer> {

     Status findByIniciado(String iniciado);
}
