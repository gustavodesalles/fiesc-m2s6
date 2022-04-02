package dive.tech.projeto.exercicios.dao;

import dive.tech.projeto.exercicios.entity.Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoDao {
    private List<Curso> cursos = new ArrayList<>();

    public List<Curso> obterCursos() {
        return cursos;
    }

    public Curso criarCurso(Curso curso) {
        cursos.add(curso);
        return curso;
    }

    public Curso deletarCurso(Curso curso) {
        cursos.remove(curso);
        return curso;
    }

    public Curso obterCursoPorId(Long id) {
        for (Curso curso : cursos) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        return null;
    }

}
