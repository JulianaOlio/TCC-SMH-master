package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.Endereco;
import com.letscodeTCCSMH.TCCSMH.Model.Status;
import com.letscodeTCCSMH.TCCSMH.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
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

    public void deletarStatus(Integer id) throws Exception {
        Optional<Status> statusAtual = statusRepository.findById(id);
        if (statusAtual.isEmpty()) {
            throw new Exception("Status não localizado");
        }
        statusRepository.deleteById(id);
            }


}

