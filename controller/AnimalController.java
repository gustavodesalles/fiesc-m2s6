package dive.tech.projeto.exercicios.controller;

import dive.tech.projeto.exercicios.entity.Animal;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/animal")
public class AnimalController {

    //ex. 2
    @GET
    @Produces("text/plain")
    public List<String> getEspecies() {
        List<String> especies = new ArrayList<>();

        especies.add("gato");
        especies.add("pinguim");
        especies.add("salamandra");

        return especies;
    }

    //ex. 3
    @GET
    @Path("{id}")
    @Produces("text/plain")
    public Response getEspecieById(@PathParam("id") @Min(value = 1) @Max(value = 3) Long id) {
        if (id == 1) return Response.ok("monke").build();
        if (id == 2) return Response.ok("doge").build();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    //ex. 4
    @GET
    @Path("filtro")
    @Produces("application/json")
    public Response getAnimalByFiltro(@QueryParam("nome") String nome, @QueryParam("especie") String especie) {
        List<Animal> animals = criarListaAnimais();
        List<Animal> animalsFiltered = new ArrayList<>(animals);

        for (Animal a : animals) {
            if (!StringUtils.isBlank(nome) && !a.getNome().equals(nome)) {
                animalsFiltered.remove(a);
            }
            if (!StringUtils.isBlank(especie) && !a.getEspecie().equals(especie)) {
                animalsFiltered.remove(a);
            }
        }

        return Response.ok(animalsFiltered).build();
    }

    public List<Animal> criarListaAnimais() {
        List<Animal> animals = new ArrayList<>();

        Animal animal1 = new Animal();
        animal1.setId(1L);
        animal1.setNome("Abu");
        animal1.setEspecie("Macaco");
        animals.add(animal1);

        Animal animal2 = new Animal();
        animal2.setId(2L);
        animal2.setNome("Marcel");
        animal2.setEspecie("Macaco");
        animals.add(animal2);

        Animal animal3 = new Animal();
        animal3.setId(3L);
        animal3.setNome("Bob");
        animal3.setEspecie("Cachorro");
        animals.add(animal3);

        Animal animal4 = new Animal();
        animal4.setId(4L);
        animal4.setNome("Sagwa");
        animal4.setEspecie("Gato");
        animals.add(animal4);

        return animals;
    }

    //ex. 5
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response PostAnimal(Animal animal, @Context HttpHeaders headers) {
        if (!headers.getHeaderString(HttpHeaders.AUTHORIZATION).equals("Bearer codigo123")) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }

        animal.setId(23L);
        return Response.ok(animal).build();
    }

    //ex. 6
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response AnimalPut(/*@QueryParam("nome") @Min(value = 3, message = "O nome precisa ter no mínimo 3 caracteres!")
                                  @Max(value = 20, message = "O nome precisa ter no máximo 20 caracteres!") String nome,
                              @QueryParam("especie") @Min(value = 5, message = "A espécie precisa ter no mínimo 5 caracteres!") String especie,
                              @QueryParam("id") Long id, */Animal animal) {

        if (animal.getId() == null || animal.getNome() == null || animal.getEspecie() == null) {
            return Response.serverError().entity("Atributo nulo").build();
        }

        if (animal.getNome().length() < 3) {
            return Response.serverError().entity("O nome precisa ter no mínimo 3 caracteres!").build();
        } else if (animal.getNome().length() > 20) {
            return Response.serverError().entity("O nome precisa ter no máximo 20 caracteres!").build();
        }

        if (animal.getEspecie().length() < 5) {
            return Response.serverError().entity("A espécie precisa ter no mínimo 5 caracteres!").build();
        }

        List<Animal> animals = criarListaAnimais();

        for (Animal a : animals) {
            if (a.getId() == animal.getId()) {
                a.setNome(animal.getNome());
                a.setEspecie(animal.getEspecie());

                return Response.ok(animals).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
