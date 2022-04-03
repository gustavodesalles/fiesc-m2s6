package dive.tech.projeto.exercicios.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Map;

@Path("/sistema")
@ApplicationScoped
public class SistemaController {

    @GET
    @Path("/cabecalho")
    public Response obterCabecalhos(@Context HttpHeaders headers) {
        String cabecalhos = String.valueOf(headers.getRequestHeaders());

        try {
            return Response.ok(cabecalhos).build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).status(400).build();
        }
    }

    @GET
    @Path("/cookie")
    @Produces("application/json")
    public Map<String, Cookie> obterCookies(@Context HttpHeaders headers) {
        return headers.getCookies();
    }

    @POST
    @Path("/cookie")
    @Produces("application/json")
    public Response inserirCookie(@QueryParam("valorCookie") String valorCookie) {
        NewCookie cookie = new NewCookie("meuCookie", valorCookie);
        return Response.ok("Cookie criado!").cookie(cookie).build();
    }
}
