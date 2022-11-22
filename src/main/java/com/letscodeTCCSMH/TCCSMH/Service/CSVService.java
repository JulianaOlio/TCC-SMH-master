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
    public CadastroUsuarioRepository cadastroUsuarioRepository;

    @Autowired
    public EnderecoRepository enderecoRepository;

    @Autowired
    public PerfilAcessoRepository perfilAcessoRepository;

    @Autowired
    public PermissaoRepository permissaoRepository;

    @Autowired
    public RequisicaoRepository requisicaoRepository;

    @Autowired
    public StatusRepository statusRepository;

    public void writeRelatorioRequisicaoParaCSV (Writer writer) throws Exception {
        List<Requisicao> listaRequisicao = requisicaoRepository.findAll();
        try (CSVPrinter listaCSV = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            listaCSV.printRecord("CadastroUsuario", "Endereco", "Requisicao", "PerfilAcesso");
            for (Requisicao requisicao : listaRequisicao) {
                listaCSV.printRecord(
                        requisicao.getCadastroUsuario().getNomeCompleto(),
                        requisicao.getCadastroUsuario().getEndereco(),
                        requisicao.getPerfilAcesso());
            }
        } catch (IOException e) {
            throw new Exception("Erro para criar CSV", e);
        }

        /*
        OutputStream agendaCsv = new FileOutputStream("/Users/jully/Documents/listaCSV.csv");

        Writer escritorAgenda = new PrintWriter(new OutputStreamWriter(listaRequisicao, StandardCharsets.UTF_8), true);
        escritorAgenda.write(listaRequisicao.toString());
        escritorAgenda.close();

        System.out.println(listaRequisicao);

    }
    */
    }
}
