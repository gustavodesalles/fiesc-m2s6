package dive.tech.projeto.exercicios.dao;

import dive.tech.projeto.exercicios.entity.Carro;
import dive.tech.projeto.exercicios.entity.Modelo;
import dive.tech.projeto.exercicios.entity.Pessoa;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class PessoaDao {
    private final List<Pessoa> pessoas;
    private final List<Carro> carros;
    private final List<Modelo> modelos;

    public PessoaDao() {
        this.pessoas = new ArrayList<>();
        this.carros = new ArrayList<>();
        this.modelos = new ArrayList<>();
    }

    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoasAtivas = new ArrayList<>();

        for (Pessoa p : pessoas) {
            if (p.isAtivo()) pessoasAtivas.add(p);
        }

        return pessoasAtivas;
    }

    public List<Carro> listarCarros() {
        return carros;
    }

    public List<Modelo> listarModelos() {
        return modelos;
    }

    public void salvarPessoa(Pessoa pessoa) {
        for (Carro carro : pessoa.getCarroList()) {
            if (!modelos.contains(carro.getModelo())) {
                modelos.add(carro.getModelo());
            }

            if (!carros.contains(carro)) {
                carros.add(carro);
            }
        }

        if (!pessoas.contains(pessoa)) {
            pessoas.add(pessoa);
        }
    }

    public void atualizarPessoa(Pessoa pessoa) {
        for (Pessoa p : pessoas) {
            if (Objects.equals(p.getId(), pessoa.getId())) {
                p.setNome(pessoa.getNome());
                p.setAtivo(pessoa.isAtivo());
            }
        }
    }

    public void deletarPessoa(Pessoa pessoa) {
        for (Pessoa p : pessoas) {
            if (p.equals(pessoa)) {
                p.setAtivo(false);
            }
        }
    }
}
