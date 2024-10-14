package br.com.fiap.cp_diploma.dto;

import br.com.fiap.cp_diploma.model.Sexo;
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
    private Long idDiplomado;
    private Long idCurso;
    private Sexo sexo;
    private String nomeReitor;

    public DiplomaDTO() {
    }

    public DiplomaDTO(String nomeDiplomado, String nacionalidade, String naturalidade, String numeroRg, String nomeCurso, TipoCurso tipoCurso, LocalDate dataConclusao, String tituloReitor, String cargoReitor, Long idDiplomado, Long idCurso, Sexo sexo, String nomeReitor) {
        this.nomeDiplomado = nomeDiplomado;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
        this.numeroRg = numeroRg;
        this.nomeCurso = nomeCurso;
        this.tipoCurso = tipoCurso;
        this.dataConclusao = dataConclusao;
        this.tituloReitor = tituloReitor;
        this.cargoReitor = cargoReitor;
        this.idDiplomado = idDiplomado;
        this.idCurso = idCurso;
        this.sexo = sexo;
        this.nomeReitor = nomeReitor;
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

    public Long getIdDiplomado() {
        return idDiplomado;
    }

    public void setIdDiplomado(Long idDiplomado) {
        this.idDiplomado = idDiplomado;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNomeReitor() {
        return nomeReitor;
    }

    public void setNomeReitor(String nomeReitor) {
        this.nomeReitor = nomeReitor;
    }
}
