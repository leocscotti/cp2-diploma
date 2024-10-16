package br.com.fiap.cp_diploma.dto;

import jakarta.validation.constraints.*;

public class DiplomadoRequest {
    @NotBlank(message="O nome do diplomado é obrigatório")
    private String nome;
    @NotBlank(message= "A nacionalidade do diplomado é obrigatória")
    private String nacionalidade;
    @NotBlank(message= "A naturalidade deve ser obrigatória e no formato cidade-uf, ex: Campinas-SP")
    private String naturalidade;
    @Pattern(regexp = "(^\\d{1,2}).?(\\d{3}).?(\\d{3})-?(\\d{1}|X|x$)", message = "o RG deve ser passado no formato padrão")
    private String rg;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
