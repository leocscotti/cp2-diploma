package br.com.fiap.cp_diploma.service;

import br.com.fiap.cp_diploma.dto.CursoRequest;
import br.com.fiap.cp_diploma.dto.CursoResponse;
import br.com.fiap.cp_diploma.model.Curso;
import br.com.fiap.cp_diploma.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso requestToCurso(CursoRequest cursoRequest) {
        Curso curso = new Curso();
        curso.setNome(cursoRequest.getNome());
        curso.setTipo(cursoRequest.getTipo());
        return curso;
    }

    public CursoResponse cursoToResponse(Curso curso) {
        CursoResponse cursoResponse = new CursoResponse();
        cursoResponse.setId(curso.getId());
        cursoResponse.setNome(curso.getNome());
        cursoResponse.setTipo(curso.getTipo().getTipo());
        return cursoResponse;
    }
}


