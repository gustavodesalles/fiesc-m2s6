package dive.tech.projeto.exercicios.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class Modelo implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    private String nome;

    public Modelo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Modelo() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modelo modelo = (Modelo) o;
        return Objects.equals(id, modelo.id) && Objects.equals(nome, modelo.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
