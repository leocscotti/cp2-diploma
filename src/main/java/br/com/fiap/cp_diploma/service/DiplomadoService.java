package br.com.fiap.cp_diploma.service;

import br.com.fiap.cp_diploma.dto.DiplomadoRequest;
import br.com.fiap.cp_diploma.dto.DiplomadoResponse;
import br.com.fiap.cp_diploma.model.Diplomado;
import br.com.fiap.cp_diploma.repository.DiplomadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiplomadoService {

    @Autowired
    private DiplomadoRepository diplomadoRepository;

    // Métodos Mapper
    public Diplomado requestToDiplomado(DiplomadoRequest diplomadoRequest) {
        Diplomado diplomado = new Diplomado();
        diplomado.setNome(diplomadoRequest.getNome());
        diplomado.setNacionalidade(diplomadoRequest.getNacionalidade());
        diplomado.setNaturalidade(diplomadoRequest.getNaturalidade());
        diplomado.setRg(diplomadoRequest.getRg());
        return diplomado;
    }

    public DiplomadoResponse diplomadoToResponse(Diplomado diplomado) {
        DiplomadoResponse diplomadoResponse = new DiplomadoResponse();
        diplomadoResponse.setId(diplomado.getId());
        diplomadoResponse.setNome(diplomado.getNome());
        diplomadoResponse.setNacionalidade(diplomado.getNacionalidade());
        diplomadoResponse.setNaturalidade(diplomado.getNaturalidade());
        diplomadoResponse.setRg(diplomado.getRg());
        return diplomadoResponse;
    }
}