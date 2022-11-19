package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.CadastroUsuario;
import com.letscodeTCCSMH.TCCSMH.Model.Status;
import com.letscodeTCCSMH.TCCSMH.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService{

    @Autowired
    private StatusRepository statusRepository;

    public void salvarStatus(Status status) {
        statusRepository.save(status);
    }

    public Status buscarStatus(String status) {
        return statusRepository.findByIniciado(status);
    }

    public boolean atualizarStatus(String iniciado, Status status) {
        Status statusBD = statusRepository.findByIniciado(iniciado);
        if (status != null) {
            statusBD.setIniciado(status.getEmAndamento());
            statusRepository.save(status);
            return true;
        }
        return false;
    }

    public boolean excluirStatus(String status) {
        Status statusAtual = statusRepository.findByIniciado(status);
        if (statusAtual != null) {
            statusRepository.delete(statusAtual);
            return true;
        }
        return false;
    }

    public List<Status> listarStatus(String status) {
        if (status != null) {
            return statusRepository.findByIniciado();
        } else {
            return statusRepository.findAll();
        }
    }
}
