package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.Status;
import com.letscodeTCCSMH.TCCSMH.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public void salvarStatus(Status status) {
        statusRepository.save(status);
    }
    public Status buscarStatus(String status) {
        return statusRepository.findByNome(status);
    }

    public boolean atualizarStatus(String nome, Status status) {
        Status statusBD = statusRepository.findByNome(nome);
        if (status != null) {
            statusBD.setNome(status.getNome());
            statusRepository.save(status);
            return true;
        }
        return false;
    }

    public boolean excluirStatus(String status) {
        Status statusAtual = statusRepository.findByNome(status);
        if (statusAtual != null) {
            statusRepository.delete(statusAtual);
            return true;
        }
        return false;
    }
}
