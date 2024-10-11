package br.com.fiap.cp_diploma.controller;

import br.com.fiap.cp_diploma.dto.DiplomaDTO;
import br.com.fiap.cp_diploma.model.Diploma;
import br.com.fiap.cp_diploma.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/diplomas")
public class DiplomaController {

    @Autowired
    private DiplomaService diplomaService;

    @PostMapping
    public ResponseEntity<Diploma> criarDiploma(@RequestBody DiplomaDTO diplomaDTO) {
        Diploma novoDiploma = diplomaService.criarDiploma(diplomaDTO);
        return ResponseEntity.ok(novoDiploma);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diploma> buscarDiplomaPorId(@PathVariable UUID id) {
        Diploma diploma = diplomaService.buscarPorId(id);
        return ResponseEntity.ok(diploma);
    }

    @GetMapping("/{id}/texto")
    public ResponseEntity<String> gerarTextoDiploma(@PathVariable UUID id) {
        Diploma diploma = diplomaService.buscarPorId(id);
        String textoDiploma = diplomaService.gerarTextoDiploma(diploma);
        return ResponseEntity.ok(textoDiploma);
    }
}