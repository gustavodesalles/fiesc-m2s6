package dive.tech.projeto.exercicios.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class Carro implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private Modelo modelo;

    public Carro(Long id, String nome, Modelo modelo) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
    }

    public Carro() {
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

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(id, carro.id) && Objects.equals(nome, carro.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
