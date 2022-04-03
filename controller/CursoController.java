package dive.tech.projeto.exercicios.controller;

import dive.tech.projeto.exercicios.entity.Curso;
import dive.tech.projeto.exercicios.service.CursoService;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/curso")
@ApplicationScoped
public class CursoController {
    private CursoService cursoService;

    public CursoController() {
        this.cursoService = new CursoService();
    }

    @GET
    @Produces("application/json")
    public Response obterCursos(@QueryParam("nome") String nome) {
        return Response.ok(cursoService.obterCursos(nome)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criarCurso(@Valid Curso curso, @HeaderParam("Authorization") String authorization) {

        if (!"Bearer senha123".equals(authorization)) {
            return Response.status(403).build();
        }

        try {
            return Response.ok(cursoService.criarCurso(curso)).status(201).build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).status(400).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response obterCursoPorId(@PathParam("id") Long id) {
        try {
            return Response.ok(cursoService.obterCursoPorId(id)).build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).status(400).build();
        }
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response editarCurso(Curso curso) {
        try {
            return Response.ok(cursoService.editarCurso(curso)).build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).status(400).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deletarCurso(@PathParam("id") Long id) {
        try {
            return Response.ok(cursoService.deletarCurso(id)).build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).status(400).build();
        }
    }
}
