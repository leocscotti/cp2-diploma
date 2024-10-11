package br.com.fiap.cp_diploma.service;

import br.com.fiap.cp_diploma.dto.DiplomaDTO;
import br.com.fiap.cp_diploma.model.Curso;
import br.com.fiap.cp_diploma.model.Diploma;
import br.com.fiap.cp_diploma.model.Diplomado;
import br.com.fiap.cp_diploma.model.Sexo;
import br.com.fiap.cp_diploma.repository.CursoRepository;
import br.com.fiap.cp_diploma.repository.DiplomaRepository;
import br.com.fiap.cp_diploma.repository.DiplomadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DiplomaService {

    @Autowired
    private DiplomaRepository diplomaRepository;

    @Autowired
    private DiplomadoRepository diplomadoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Diploma criarDiploma(DiplomaDTO diplomaDTO) {
        Diploma diploma = new Diploma();

        Diplomado diplomado = diplomadoRepository.findById(diplomaDTO.getIdDiplomado())
                .orElseThrow(() -> new RuntimeException("Diplomado não encontrado"));

        Curso curso = cursoRepository.findById(diplomaDTO.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        diploma.setDiplomado(diplomado);
        diploma.setCurso(curso);
        diploma.setDataConclusao(diplomaDTO.getDataConclusao());
        diploma.setSexo(diplomaDTO.getSexo());
        diploma.setNomeReitor(diplomaDTO.getNomeReitor());

        return diplomaRepository.save(diploma);
    }

    public String gerarTextoDiploma(Diploma diploma) {

        String tituloReitor = diploma.getSexo() == Sexo.M ? "Prof. Dr. " + diploma.getNomeReitor() : "Profa. Dra. " + diploma.getNomeReitor();
        String cargoReitor = diploma.getSexo() == Sexo.M ? "Reitor" : "Reitora";


        return String.format(
                "O %s, %s da Universidade Fake, no uso de suas atribuições, confere a %s, de nacionalidade %s, natural de %s, portador do RG %s, " +
                        "o presente diploma de %s, do curso de %s, por ter concluído seus estudos nesta instituição de ensino no dia %s.",
                tituloReitor,
                cargoReitor,
                diploma.getDiplomado().getNome(),
                diploma.getDiplomado().getNacionalidade(),
                diploma.getDiplomado().getNaturalidade(),
                diploma.getDiplomado().getRg(),
                diploma.getCurso().getTipo(),
                diploma.getCurso().getNome(),
                diploma.getDataConclusao());
    }


    public Diploma buscarPorId(UUID id) {
        return diplomaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diploma não encontrado"));
    }
}
