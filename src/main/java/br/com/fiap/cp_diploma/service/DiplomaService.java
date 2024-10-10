package br.com.fiap.cp_diploma.service;

import br.com.fiap.cp_diploma.model.Diploma;
import br.com.fiap.cp_diploma.model.Sexo;
import org.springframework.stereotype.Service;

@Service
public class DiplomaService {

    public String gerarTextoDiploma(Diploma diploma) {
        String tituloReitor = diploma.getSexo() == Sexo.M ? "Prof. Dr. " + diploma.getNomeReitor() : "Profa. Dra. " + diploma.getNomeReitor();
        String cargoReitor = diploma.getSexo() == Sexo.M ? "Reitor" : "Reitora";

        return String.format("O %s, %s da Universidade Fake, no uso de suas atribuições, " +
                        "confere a %s, de nacionalidade %s, natural de %s, portador do RG %s, " +
                        "o presente diploma de %s, do curso de %s, por ter concluído seus estudos nesta " +
                        "instituição de ensino no dia %s.",
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
}
