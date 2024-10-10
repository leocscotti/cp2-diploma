package br.com.fiap.cp_diploma.controller;


import br.com.fiap.cp_diploma.dto.CursoRequest;
import br.com.fiap.cp_diploma.dto.CursoResponse;
import br.com.fiap.cp_diploma.model.Curso;
import br.com.fiap.cp_diploma.repository.CursoRepository;
import br.com.fiap.cp_diploma.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoResponse> criarCurso(@RequestBody @Valid CursoRequest cursoRequest) {
        Curso curso = cursoService.requestToCurso(cursoRequest);
        Curso novoCurso = cursoRepository.save(curso);
        CursoResponse cursoResponse = cursoService.cursoToResponse(novoCurso);
        return ResponseEntity.ok(cursoResponse);
    }

    @GetMapping
    public ResponseEntity<List<CursoResponse>> listarCursos() {
        List<Curso> cursos= cursoRepository.findAll();
        List<CursoResponse> cursoResponses= cursos.stream()
                .map(cursoService::cursoToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cursoResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> buscarCursoPorId(@PathVariable Long id, @RequestBody @Valid CursoRequest cursoRequest) {
        Optional<Curso> curso= cursoRepository.findById(id);
        if (curso.isPresent()) {
            CursoResponse cursoResponse= cursoService.cursoToResponse(curso.get());
            return ResponseEntity.ok(cursoResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponse> atualizarCursoPorId(@PathVariable Long id, @RequestBody @Valid CursoRequest cursoRequest) {
        Optional<Curso> optionalCurso= cursoRepository.findById(id);
        if(optionalCurso.isPresent()){
            Curso curso= optionalCurso.get();
            curso.setNome(cursoRequest.getNome());
            curso.setTipo(cursoRequest.getTipo());
            Curso cursoAtualizado= cursoRepository.save(curso);
            CursoResponse cursoResponse= cursoService.cursoToResponse(cursoAtualizado);
            return ResponseEntity.ok(cursoResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresaPorId(@PathVariable Long id){
        Optional<Curso> curso= cursoRepository.findById(id);
        if(curso.isPresent()){
            cursoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

