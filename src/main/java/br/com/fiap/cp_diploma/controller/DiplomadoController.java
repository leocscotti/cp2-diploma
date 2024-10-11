package br.com.fiap.cp_diploma.controller;

import br.com.fiap.cp_diploma.dto.DiplomadoRequest;
import br.com.fiap.cp_diploma.dto.DiplomadoResponse;
import br.com.fiap.cp_diploma.model.Diplomado;
import br.com.fiap.cp_diploma.repository.DiplomadoRepository;
import br.com.fiap.cp_diploma.service.DiplomadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diplomados")
public class DiplomadoController {

    @Autowired
    private DiplomadoRepository diplomadoRepository;
    @Autowired
    private DiplomadoService diplomadoService;

    @PostMapping
    public ResponseEntity<DiplomadoResponse> criarDiplomado (@RequestBody @Valid DiplomadoRequest diplomadoRequest) {
        Diplomado diplomado= diplomadoService.requestToDiplomado(diplomadoRequest);
        Diplomado novoDiplomado= diplomadoRepository.save(diplomado);
        DiplomadoResponse diplomadoResponse= diplomadoService.diplomadoToResponse(novoDiplomado);
        return ResponseEntity.ok(diplomadoResponse);
    }

    @GetMapping
    public ResponseEntity<List<DiplomadoResponse>> listarDiplomados () {
        List<Diplomado> diplomados= diplomadoRepository.findAll();
        List<DiplomadoResponse> diplomadoResponses= diplomados.stream()
                .map(diplomadoService::diplomadoToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(diplomadoResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiplomadoResponse> buscarDiplomadoPorId(@PathVariable Long id, @RequestBody @Valid DiplomadoRequest diplomadoRequest) {
        Optional<Diplomado> diplomado= diplomadoRepository.findById(id);
        if(diplomado.isPresent()){
            DiplomadoResponse diplomadoResponse= diplomadoService.diplomadoToResponse(diplomado.get());
            return ResponseEntity.ok(diplomadoResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiplomadoResponse> atualizarDiplomadoPorId(@PathVariable Long id, @RequestBody @Valid DiplomadoRequest diplomadoRequest) {
        Optional<Diplomado> optionalDiplomado= diplomadoRepository.findById(id);
        if(optionalDiplomado.isPresent()) {
            Diplomado diplomado= optionalDiplomado.get();
            diplomado.setNome(diplomadoRequest.getNome());
            diplomado.setNacionalidade(diplomado.getNacionalidade());
            diplomado.setNaturalidade(diplomado.getNaturalidade());
            diplomado.setRg(diplomado.getRg());
            Diplomado diplomadoAtualizado= diplomadoRepository.save(diplomado);
            DiplomadoResponse diplomadoResponse= diplomadoService.diplomadoToResponse(diplomadoAtualizado);
            return ResponseEntity.ok(diplomadoResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDiplomadoPorId(@PathVariable Long id) {
        Optional<Diplomado> diplomado= diplomadoRepository.findById(id);
        if(diplomado.isPresent()){
            diplomadoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
