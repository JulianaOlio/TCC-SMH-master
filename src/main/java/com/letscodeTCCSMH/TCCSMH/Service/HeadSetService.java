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

//    public boolean atualizarHeadSet(String numero, HeadSet headSet) {
//        HeadSet headSetBD = headSetRepository.findByHeadSet(numero);
//        if (headSet != null) {
//            headSetBD.setNumeroHeadSet(headSet.getNumeroHeadSet());
//            headSetRepository.save(headSetBD);
//            return true;
//        }
//        return false;
//    }
//
//       public void excluiHeadSet(Integer id) throws Exception{
//        var headset = headSetRepository.findById(id);
//        if(headset.isEmpty()){
//            throw new Exception("HeadSet não encontrado");
//        }
//        headSetRepository.deleteById(id);
//               }

}
