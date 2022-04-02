package dive.tech.projeto.exercicios.service;

import dive.tech.projeto.exercicios.dao.CursoDao;
import dive.tech.projeto.exercicios.entity.Curso;

import java.util.List;

public class CursoService {

    CursoDao cursoDao = new CursoDao();

    public List<Curso> obterCursos() {
        return cursoDao.obterCursos();
    }

    public Curso criarCurso(Curso curso) {
        // Obtém-se a quantidade de cursos cadastrados, determinando o ID a partir desta.
        List<Curso> cursos = cursoDao.obterCursos();

        if (cursos.size() == 0) {
            curso.setId(1L);
        } else {
            curso.setId(cursos.get(cursos.size() - 1).getId() + 1);
        }
        curso.setNome("Curso " + curso.getId());

        return cursoDao.criarCurso(curso);
    }

    public Curso obterCursoPorId(Long id) throws Exception {
        Curso cursoEncontrado = cursoDao.obterCursoPorId(id);

        if (cursoEncontrado == null) throw new Exception("Curso não encontrado.");

        return cursoEncontrado;
    }
    public Curso editarCurso(Curso curso) throws Exception {
        // São comparados os IDs dos cursos cadastrados com o ID do parâmetro
        Curso cursoEncontrado = cursoDao.obterCursoPorId(curso.getId());

        if (cursoEncontrado == null) throw new Exception("Curso não encontrado.");

        // A atualização é feita na camada de serviços; não é usado o DAO
        cursoEncontrado.setNome(curso.getNome());
        cursoEncontrado.setDisciplinas(curso.getDisciplinas());

        return cursoEncontrado;
    }

    public List<Curso> deletarCurso(Long id) throws Exception {
        List<Curso> cursos = cursoDao.obterCursos();
        Curso cursoEncontrado = cursoDao.obterCursoPorId(id);

        if (cursoEncontrado == null) throw new Exception("Curso não encontrado.");

        cursos.remove(cursoEncontrado);
        return cursos;
    }
}
