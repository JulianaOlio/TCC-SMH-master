package com.letscodeTCCSMH.TCCSMH.Service;

import com.letscodeTCCSMH.TCCSMH.Model.Requisicao;
import com.letscodeTCCSMH.TCCSMH.Repository.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    public RequisicaoRepository requisicaoRepository;


    public void writeRelatorioRequisicaoParaCSV (Writer writer) throws Exception {
        List<Requisicao> listaRequisicao = requisicaoRepository.findAll();
        try (CSVPrinter listaCSV = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            listaCSV.printRecord("Usuario", "Endereco", "DataInicial","DataFinal","Motivo", "Status");
            for (Requisicao requisicao : listaRequisicao) {
                listaCSV.printRecord(
                        requisicao.getCadastroUsuario().getNomeCompleto(),
                        requisicao.getCadastroUsuario().getEndereco(),
                        requisicao.getDataInicial(),
                        requisicao.getDataFinal(),
                        requisicao.getMotivo(),
                        requisicao.getStatus());

         }
        } catch (IOException e) {
            throw new Exception("Erro para criar CSV", e);
        }
            }
}
