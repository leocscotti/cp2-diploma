package br.com.fiap.cp_diploma.dto;

import br.com.fiap.cp_diploma.model.TipoCurso;

import java.time.LocalDate;

public class DiplomaDTO {
    private String nomeDiplomado;
    private String nacionalidade;
    private String naturalidade;
    private String numeroRg;
    private String nomeCurso;
    private TipoCurso tipoCurso;
    private LocalDate dataConclusao;
    private String tituloReitor;
    private String cargoReitor;

    public DiplomaDTO() {
    }

    public DiplomaDTO(String nomeDiplomado, String nacionalidade, String naturalidade, String numeroRg, String nomeCurso, TipoCurso tipoCurso, LocalDate dataConclusao, String tituloReitor, String cargoReitor) {
        this.nomeDiplomado = nomeDiplomado;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
        this.numeroRg = numeroRg;
        this.nomeCurso = nomeCurso;
        this.tipoCurso = tipoCurso;
        this.dataConclusao = dataConclusao;
        this.tituloReitor = tituloReitor;
        this.cargoReitor = cargoReitor;
    }

    public String getNomeDiplomado() {
        return nomeDiplomado;
    }

    public void setNomeDiplomado(String nomeDiplomado) {
        this.nomeDiplomado = nomeDiplomado;
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

    public String getNumeroRg() {
        return numeroRg;
    }

    public void setNumeroRg(String numeroRg) {
        this.numeroRg = numeroRg;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public TipoCurso getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(TipoCurso tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getTituloReitor() {
        return tituloReitor;
    }

    public void setTituloReitor(String tituloReitor) {
        this.tituloReitor = tituloReitor;
    }

    public String getCargoReitor() {
        return cargoReitor;
    }

    public void setCargoReitor(String cargoReitor) {
        this.cargoReitor = cargoReitor;
    }
}
