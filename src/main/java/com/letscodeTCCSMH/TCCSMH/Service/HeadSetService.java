package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.Endereco;
import com.letscodeTCCSMH.TCCSMH.Model.HeadSet;
import com.letscodeTCCSMH.TCCSMH.Model.Requisicao;
import com.letscodeTCCSMH.TCCSMH.Repository.HeadSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HeadSetService {

    @Autowired
    private HeadSetRepository headSetRepository;


    public HeadSet salvarHeadSet (HeadSet headSet) {
        return headSetRepository.save(headSet);
  }

    public HeadSet buscarHeadSet(Integer id) {
        var buscandoHeadSet = headSetRepository.findById(id);
        if (buscandoHeadSet.isEmpty()) {
            throw new IllegalArgumentException("Headset não encontrado!");
        }
        return buscandoHeadSet.get();
    }

    public HeadSet atualizarHeadSet(Integer id, HeadSet headSet) throws Exception {
        var localizandoHeadSet = headSetRepository.findById(id);
        if (localizandoHeadSet.isEmpty()) {
            throw new Exception("HeadSet não encontrado");
        }
        var atualizaHeadSet = HeadSet.builder()
                .numeroAntigoHeadSet(headSet.getNumeroNovoHeadSet())
                .build();
        headSetRepository.save(headSet);
        return atualizaHeadSet;
    }

       public void excluiHeadSet(Integer id) throws Exception{
        var headset = headSetRepository.findById(id);
        if(headset.isEmpty()){
            throw new Exception("HeadSet não encontrado");
        }
        headSetRepository.deleteById(id);
               }

}
