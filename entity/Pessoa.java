package dive.tech.projeto.exercicios.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    private String nome;

    @NotNull
    private boolean ativo;

    @NotNull
    private List<Carro> carroList;

    public Pessoa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.ativo = true;
        this.carroList = new ArrayList<>();
    }

    public Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Carro> getCarroList() {
        return carroList;
    }

    public void setCarroList(List<Carro> carroList) {
        this.carroList = carroList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return ativo == pessoa.ativo && Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, ativo);
    }
}
