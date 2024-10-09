package model;

public enum Sexo {
    M("Sexo Masculino"),
    F("Sexo Feminino");

    private String sexo;

    Sexo(String sexo) {
        this.sexo= sexo;
    }

    public String getSexo() {
        return sexo;
    }
}
