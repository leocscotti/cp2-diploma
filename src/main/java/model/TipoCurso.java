package model;

public enum TipoCurso {
    GRADUACAO("TipoCurso Graduacao"),
    POS_GRADUACAO("TipoCurso Pos_Graduacao");

    private String tipo;

    TipoCurso(String tipo){
        this.tipo= tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
