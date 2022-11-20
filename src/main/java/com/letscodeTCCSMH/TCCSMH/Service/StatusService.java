package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.Status;
import com.letscodeTCCSMH.TCCSMH.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public void salvarStatus(Status status) {
        statusRepository.save(status);
    }

    public Status buscarStatus(String status) {
        return statusRepository.findByStatus(status);
    }

    public boolean atualizarStatus(String status, Status statusAtual){
        Status statusBD = statusRepository.findByStatus(status);
        if (status != null) {
            statusBD.setId(statusAtual.getId());
            statusBD.setRequisicao(statusAtual.getRequisicao());
            statusBD.setStatus(statusAtual.getStatus());
            statusRepository.save(statusAtual);
            return true;
        }
        return false;
    }

    public void deletarStatus(Integer id) throws Exception {
        Optional<Status> statusAtual = statusRepository.findById(id);
        if (statusAtual.isEmpty()) {
            throw new Exception("Status não localizado");
        }
        statusRepository.deleteById(id);
            }

    public List<Status> listarStatus(){
        return statusRepository.findAll();
    }
    }

