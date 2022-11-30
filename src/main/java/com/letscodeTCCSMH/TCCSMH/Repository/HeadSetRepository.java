package com.letscodeTCCSMH.TCCSMH.Repository;


import com.letscodeTCCSMH.TCCSMH.Model.HeadSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadSetRepository extends JpaRepository<HeadSet, Integer> {
    //HeadSet findByHeadSet (String numero);
}
