package br.com.fiap.cp_diploma.dto;

import br.com.fiap.cp_diploma.model.TipoCurso;
import jakarta.validation.constraints.*;

public class CursoRequest {
    @NotBlank(message = "O nome do curso é obrigatório")
    private String nome;
    @NotNull(message = "O tipo do curso é obrigatório")
    private TipoCurso tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCurso getTipo() {
        return tipo;
    }

    public void setTipo(TipoCurso tipo) {
        this.tipo = tipo;
    }
}
