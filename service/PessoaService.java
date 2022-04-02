package dive.tech.projeto.exercicios.service;

import dive.tech.projeto.exercicios.dao.PessoaDao;
import dive.tech.projeto.exercicios.entity.Carro;
import dive.tech.projeto.exercicios.entity.Modelo;
import dive.tech.projeto.exercicios.entity.Pessoa;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PessoaService {
    private final PessoaDao pessoaDao;

    public PessoaService() {
        this.pessoaDao = new PessoaDao();
    }

    public List<Pessoa> listarPessoas() {
        return pessoaDao.listarPessoas();
    }

    public List<Carro> listarCarros() {
        return pessoaDao.listarCarros();
    }

    public List<Modelo> listarModelos() {
        return pessoaDao.listarModelos();
    }

    public void salvarPessoa(Pessoa pessoa) {
        pessoaDao.salvarPessoa(pessoa);
    }

    public void atualizarPessoa(Pessoa pessoa) {
        pessoaDao.atualizarPessoa(pessoa);
    }

    public void deletarPessoa(Pessoa pessoa) {
        pessoaDao.deletarPessoa(pessoa);
    }
}
