package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.HeadSet;
import com.letscodeTCCSMH.TCCSMH.Repository.HeadSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadSetService {

    @Autowired
    private HeadSetRepository headSetRepository;


    public HeadSet salvarHeadSet (HeadSet headSet) {
        return headSetRepository.save(headSet);
  }

    public List<HeadSet> listaHeadSet() {
        return (List<HeadSet>) headSetRepository.findAll();
    }

    public boolean atualizarHeadSet(String numeroHeadSet, HeadSet headSet) {
        HeadSet headSetBD = headSetRepository.findByNumeroHeadSet(numeroHeadSet);
       if (numeroHeadSet != null) {
           headSetBD.setNumeroHeadSet(headSet.getNumeroHeadSet());
            headSetRepository.save(headSetBD);
           return true;
      }
       return false;
    }

    public boolean excluirHeadSet(String numeroHeadSet) {
        HeadSet headSet = headSetRepository.findByNumeroHeadSet(numeroHeadSet);
        if (headSet != null) {
            headSetRepository.delete(headSet);
            return true;
        }
        return false;
    }

}

