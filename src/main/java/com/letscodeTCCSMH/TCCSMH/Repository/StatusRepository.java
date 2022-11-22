package com.letscodeTCCSMH.TCCSMH.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status,Integer> {

      List<Status> findAll();

    Status findByStatus(String status);
}
