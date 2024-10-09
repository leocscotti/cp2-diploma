package model;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name="tb_diploma")
public class Diploma {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinTable(name = "tb_diplomado_diploma",
            joinColumns = @JoinColumn(name = "id_diploma", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_diplomado", referencedColumnName = "id")
    )
    private Collection<Diplomado> diplomados;

    @ManyToOne
    @JoinTable(name = "tb_curso_diploma",
            joinColumns = @JoinColumn(name = "id_diploma", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_curso", referencedColumnName = "id")
    )
    private Collection<Curso> cursos;

    @Column(name= "data_conclusao")
    private LocalDateTime dataConclusao;

   @Column(name= "sexo")
   @Enumerated(EnumType.STRING)
    private Sexo sexo;

   @Column(name= "nome_reitor")
    private String nomeReitor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<Diplomado> getDiplomados() {
        return diplomados;
    }

    public void setDiplomados(Collection<Diplomado> diplomados) {
        this.diplomados = diplomados;
    }

    public Collection<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Collection<Curso> cursos) {
        this.cursos = cursos;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
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
