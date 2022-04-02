package dive.tech.projeto.exercicios.controller;

import dive.tech.projeto.exercicios.entity.Pessoa;
import dive.tech.projeto.exercicios.service.PessoaService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/trythis")
@ApplicationScoped
public class PessoaController {
    private final PessoaService pessoaService;

    public PessoaController() {
        this.pessoaService = new PessoaService();
    }

    @GET
    @Path("/pessoas")
    @Produces("application/json")
    public Response listarPessoas(@Context HttpHeaders headers) {
        if (!"Bearer codigo123".equals(headers.getHeaderString(HttpHeaders.AUTHORIZATION))) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        return Response.ok(pessoaService.listarPessoas()).build();
    }

    @GET
    @Path("/carros")
    @Produces("application/json")
    public Response listarCarros(@Context HttpHeaders headers) {
        if (!"Bearer codigo123".equals(headers.getHeaderString(HttpHeaders.AUTHORIZATION))) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        return Response.ok(pessoaService.listarCarros()).build();
    }

    @GET
    @Path("/modelos")
    @Produces("application/json")
    public Response listarModelos(@Context HttpHeaders headers) {
        if (!"Bearer codigo123".equals(headers.getHeaderString(HttpHeaders.AUTHORIZATION))) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        return Response.ok(pessoaService.listarModelos()).build();
    }

    @POST
    @Consumes("application/json")
    public Response salvarPessoa(Pessoa pessoa, @Context HttpHeaders headers) {
        if (!"Bearer codigo123".equals(headers.getHeaderString(HttpHeaders.AUTHORIZATION))) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        pessoaService.salvarPessoa(pessoa);
        return Response.ok("Pessoa salva!").build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response atualizarPessoa(Pessoa pessoa, @Context HttpHeaders headers) {
        if (!"Bearer codigo123".equals(headers.getHeaderString(HttpHeaders.AUTHORIZATION))) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        pessoaService.atualizarPessoa(pessoa);
        return Response.ok("Pessoa atualizada!").build();
    }

    @DELETE
    @Consumes("application/json")
    public Response deletarPessoa(Pessoa pessoa, @Context HttpHeaders headers) {
        if (!"Bearer codigo123".equals(headers.getHeaderString(HttpHeaders.AUTHORIZATION))) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        pessoaService.deletarPessoa(pessoa);
        return Response.ok("Pessoa deletada!").build();
    }

    @GET
    @Path("/html")
    @Produces("text/html")
    public String obterPessoasHtml() {
        String html = "<html><ul>";
        List<Pessoa> pessoas = pessoaService.listarPessoas();

        for (Pessoa p : pessoas) {
            html += "<li>" + p.getId() + ", " + p.getNome() + "</li>";
        }

        html += "</ul></html>";
        return html;
    }

}
