package br.com.fiap.cp_diploma.repository;

import br.com.fiap.cp_diploma.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
